package com.elastic.model;

import com.elastic.constants.Status;
import lombok.*;

import java.io.Serializable;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/5/11 16:09
 */
@Getter
@Setter
public class Foo implements Serializable{
    private long id;
    private String location;
    private Status status;

    public Foo(long id, String location, Status status){
        this.id = id;
        this.location = location;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", status=" + status +
                '}';
    }
}