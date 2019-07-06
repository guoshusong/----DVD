package com.summer.demo.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        //创建一个jobDetail的实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(Schedule.class).withIdentity("myjob").build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
