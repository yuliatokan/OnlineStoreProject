package edu.store.repository;

import edu.store.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    @Query("SELECT l FROM ToDoList l where l.num = :num")
    ToDoList findItemByNum(@Param("num") int num);

    @Query("SELECT l FROM ToDoList l where l.time >= :time")
    List<ToDoList> findNewItem(@Param("time") Long time);
}
