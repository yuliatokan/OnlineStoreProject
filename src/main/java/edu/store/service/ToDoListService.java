package edu.store.service;

import edu.store.entity.ToDoList;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ToDoListService {
    @Transactional(readOnly = true)
    List<ToDoList> getAllItems();

    @Transactional
    void addItem(int num, String item, Date date, Long time);

    @Transactional
    void updateItem(ToDoList toDoList);

    @Transactional
    void updateItem(Long id, int num_after);

    @Transactional
    ToDoList getItemByNum(int num);

    @Transactional
    List<ToDoList> getNewItem(Long time);

    @Transactional
    void deleteItem(Long id);

    @Transactional
    ToDoList getItem(Long id);
}
