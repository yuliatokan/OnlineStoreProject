package edu.store.service.impl;

import edu.store.entity.ToDoList;
import edu.store.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class DefaultToDoListService implements edu.store.service.ToDoListService {
    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ToDoList> getAllItems() {
        List<ToDoList> list = toDoListRepository.findAll();
        list.sort(Comparator.comparingInt(ToDoList::getNum));
        return list;
    }

    @Override
    @Transactional
    public void addItem(int num, String item, Date date, Long time) {
        toDoListRepository.save(new ToDoList(num, item, date, time));
    }

    @Override
    @Transactional
    public void updateItem(ToDoList toDoList) {
        toDoListRepository.save(toDoList);
    }

    @Override
    @Transactional
    public void updateItem(Long id, int num_after) {
        ToDoList item_for_update = toDoListRepository.findById(id).orElse(null);
        int num_before = item_for_update.getNum();

        List<ToDoList> items = toDoListRepository.findAll();
        for (ToDoList item : items) {
            if (item.getNum() >= num_after && item.getNum() < num_before) {
                item.setNum(item.getNum() + 1);
                toDoListRepository.save(item);
            }
        }
        item_for_update.setNum(num_after);
        toDoListRepository.save(item_for_update);
    }

    @Override
    @Transactional
    public ToDoList getItemByNum(int num) {
        return toDoListRepository.findItemByNum(num);
    }

    @Override
    @Transactional
    public List<ToDoList> getNewItem(Long time) {
        return toDoListRepository.findNewItem(time);
    }

    @Override
    @Transactional
    public void deleteItem(Long id) {
        toDoListRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ToDoList getItem(Long id) {
        return toDoListRepository.findById(id).orElse(null);
    }
}
