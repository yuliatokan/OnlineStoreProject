package edu.store.service;

import edu.store.entity.ToDoList;
import edu.store.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class ToDoListService {
    @Autowired
    private ToDoListRepository toDoListRepository;

    @Transactional(readOnly = true)
    public List<ToDoList> getAllItems() {
        List<ToDoList> list = toDoListRepository.findAll();
        Collections.sort(list, (x,y)->x.getNum()-y.getNum());
        return list;
    }

    @Transactional
    public void addItem(int num, String item, Date date, Long time) {
        toDoListRepository.save(new ToDoList(num, item, date, time));
    }

    @Transactional
    public void updateItem(ToDoList toDoList){
        toDoListRepository.save(toDoList);
    }

    @Transactional
    public void updateItem(Long id, int num_after) {
        ToDoList item_for_update = toDoListRepository.findById(id).get();
        int num_before = item_for_update.getNum();

        List<ToDoList> items = toDoListRepository.findAll();
        for(ToDoList item: items ){
            if(item.getNum()>=num_after && item.getNum()<num_before){
                item.setNum(item.getNum()+1);
                toDoListRepository.save(item);
            }
        }
        item_for_update.setNum(num_after);
        toDoListRepository.save(item_for_update);
    }

    @Transactional
    public ToDoList getItemByNum(int num) {
        return toDoListRepository.findItemByNum(num);
    }

    @Transactional
    public List<ToDoList> getNewItem(Long time) {
        return toDoListRepository.findNewItem(time);
    }

    @Transactional
    public void deleteItem(Long id){
        toDoListRepository.deleteById(id);
    }

    @Transactional
    public ToDoList getItem(Long id){
        return toDoListRepository.findById(id).get();
    }
}
