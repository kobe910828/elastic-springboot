package com.elastic.repository;

import com.elastic.constants.Status;
import com.elastic.model.Foo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/5/11 16:20
 */
@Repository
public class FooRepository {
    private Map<Long,Foo> data = new ConcurrentHashMap<>(300,1);
    public FooRepository(){init();}
    private void init(){
        addData(0L, 6L, "Beijing");
        addData(6L, 12L, "Shanghai");
        addData(12L, 18L, "Guangzhou");
    }
    private void addData(final Long idFrom,final Long idTo,final String location){
        for(long i=idFrom; i < idTo; i++) {
            data.put(i,new Foo(i,location,Status.TODO));
        }
    }
    public List<Foo> findTodoData(final String location, final int limit) {
        List<Foo> result = new ArrayList<>(limit);
        int count = 0;
        for (Map.Entry<Long, Foo> each : data.entrySet()) {
            Foo foo = each.getValue();
            if (foo.getLocation().equals(location) && foo.getStatus() == Status.TODO) {
                result.add(foo);
                count++;
                if (count == limit) {
                    break;
                }
            }
        }
        return result;
    }
    public void setCompleted(final long id) {
        data.get(id).setStatus(Status.COMPLETED);
    }
}