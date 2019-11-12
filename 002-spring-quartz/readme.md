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


