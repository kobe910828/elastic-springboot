package com.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.elastic.model.Foo;
import com.elastic.repository.FooRepository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 基于时间驱动的任务
 * @author xin.huang
 * @version v1.0
 * @date 2018/5/10 15:40
 */
public class MySimpleJob implements SimpleJob {
    @Resource
    private FooRepository fooRepository;

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss")
                        .format(new Date()), Thread.currentThread().getId(), "SIMPLE"));

        List<Foo> data = fooRepository.findTodoData(shardingContext.getShardingParameter(), 3);
        for (Foo each : data) {
            System.out.println(each);
            fooRepository.setCompleted(each.getId());
            System.out.println(each);
        }
    }
}
