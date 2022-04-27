package edu.store.controller.restController;

import edu.store.entity.ToDoList;
import edu.store.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class RestToDoListController {
    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/2DoList/get_all")
    public List<ToDoList> getAllItems() {
        return toDoListService.getAllItems();
    }

    @GetMapping("/2DoList/item/{id}")
    public ToDoList getItem(@PathVariable(value = "id") Long id) {
        return toDoListService.getItem(id);
    }

    @PostMapping("/2DoList/add")
    public ToDoList addItem(@RequestBody ToDoList toDoList) {
        Long time = new Date().getTime();
        toDoListService.addItem(0, toDoList.getItem(), toDoList.getDate(), time);
        return toDoList;
    }

    @PostMapping("/2DoList/update/{id}")
    public void updateItem(@PathVariable(name = "id") Long id, @RequestBody ToDoList toDoList) {
        ToDoList toDoListUpdate = toDoListService.getItem(id);
        toDoListUpdate.setItem(toDoList.getItem());
        toDoListUpdate.setDate(toDoList.getDate());
        toDoListService.updateItem(toDoListUpdate);
    }

    @PostMapping("/2DoList/done/{id}")
    public void updateDoneItem(@PathVariable(name = "id") Long id) {
        ToDoList toDoListUpdate = toDoListService.getItem(id);
        toDoListUpdate.setDone(!toDoListUpdate.getDone());
        toDoListService.updateItem(toDoListUpdate);
    }

    @GetMapping("/2DoList/delete/{id}")
    public ToDoList delete(@PathVariable(name = "id") Long id) {
        ToDoList item = toDoListService.getItem(id);
        toDoListService.deleteItem(id);
        return item;
    }

    @PostMapping("/2DoList/add_item")
    public ToDoList addItem(@RequestParam(value = "num") int num, @RequestParam(value = "item") String item, @RequestParam(value = "time") Date date) {
        Long time = new Date().getTime();
        toDoListService.addItem(num, item, date, time);
        return toDoListService.getItemByNum(num);
    }

    @PostMapping("/2DoList/delete")
    public void deleteItem(@RequestParam(value = "id") Long id) {
        toDoListService.deleteItem(id);
    }

    @PostMapping("/2DoList/update_item")
    public void updateItem(@RequestParam(value = "id") Long id, @RequestParam(value = "num_after") int num_after) {
        toDoListService.updateItem(id, num_after);
    }

    @GetMapping("/2DoList/get_new")
    public List<ToDoList> getNewItems() {
        System.out.println("Start");
        Long time = new Date().getTime();
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Thread thread = Thread.currentThread();
        service.scheduleAtFixedRate(() -> {
            List<ToDoList> newList = toDoListService.getNewItem(time);
            if (newList != null && newList.size() != 0) {
                System.out.println(newList.get(0).getItem());
                System.out.println("ItemTome = " + newList.get(0).getTime());
                synchronized (thread) {
                    thread.notify();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
        try {
            synchronized (thread) {
                thread.wait(15000);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        service.shutdown();
        return toDoListService.getNewItem(time);
    }
}
