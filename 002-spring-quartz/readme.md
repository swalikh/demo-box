## 工程说明
## 002-spring-quartz
#### 1.介绍：
`本项目是一个动态创建和管理时间调度任务的系统，sprintboot自带的timer调度系统比较方便，但是灵活度太低，如果需要改变时间等调度策略就要修改代码，不太方便。本项目用的springboot和quartz整合的方式，可以实时的添加 删除 修改 查询 任务，具体的使用请看Demo。`

#### 2.项目结构：

~~~~
002-spring-quartz: 
    |---src
        |---main
            |---java(com.swalikh.demo.quartz)
                |---config          // jpa的配置类 本项目的jpa使用的快速整合
                |---controller
                |---entity
                |---job
                |---repository
                |---service
                |---QuartzBootstrap.java
            |---resources
                |---sql-script
                    |---quartz-init.sql  // 初始化数据库
                |---application.yml
        |---test
    |---pom.xml
    |---readme.md
            
~~~~

#### 3.数据表结构
```
    qrtz_blob_triggers        ---->  以Blob 类型存储的触发器                             
    qrtz_calendars            ---->  存放日历信息， quartz可配置一个日历来指定一个时间范围                         
    qrtz_cron_triggers        ---->  存放cron类型的触发器                             
    qrtz_fired_triggers       ---->  存放已触发的触发器                                 
    qrtz_job_details          ---->  存放一个jobDetail信息                             
    qrtz_job_listeners        ---->  job**监听器**                             
    qrtz_locks                ---->  存储程序的悲观锁的信息(假如使用了悲观锁)                     
    qrtz_paused_trigger_graps ---->  存放暂停掉的触发器                                     
    qrtz_scheduler_state      ---->  调度器状态                                 
    qrtz_simple_triggers      ---->  简单触发器的信息                                 
    qrtz_trigger_listeners    ---->  触发器监听器                                 
    qrtz_triggers             ---->  触发器的基本信息,里面有job当前的状态 暂停 正常                      

```

