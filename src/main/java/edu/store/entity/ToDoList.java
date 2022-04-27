package edu.store.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "to_do_list")
public class ToDoList {

    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "num")
    private int num;

    @Column(name = "item", nullable = false)
    private String item;

    @Column(name = "date")
    private Date date;

    @Column(name = "time", nullable = false)
    private Long time;

    @Column(name = "done", nullable = false)
    private Boolean done;

    public ToDoList(int num, String item, Date date, Long time) {
        this.num = num;
        this.item = item;
        this.date = date;
        this.time = time;
        this.done = false;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
