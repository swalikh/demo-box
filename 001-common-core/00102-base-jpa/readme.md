## 工程说明
## 00102-base-jpa
#### 1.介绍：
`本项目用于快速整合jpa，并且实现常用的增删改查接口，主要是jpa的依赖和baseAPI`

#### 2.项目结构：

~~~~
002-spring-quartz: 
    |---src
        |---main
            |---java(com.swalikh.jpa)
                |---base        // 需要被继承的类
                |---config      // 配置
                    |---CustomIDGenerator   // JPA配置和自定义主键 详情可以百度一下 JPA自定义主键
                    |---JpaConfig           // 复制本配置到相应的服务里面就可以了
            |---resources
                |---application.yml
                |---application-dev.yml     // 直接复制本配置到相应的服务里面就可以了
    |---pom.xml
    |---readme.md
            
~~~~

#### 3.快速整合jpa方法
```
1.在新的项目添加依赖
        <!--整合JPA用于数据存储-->
        <dependency>
            <groupId>com.swalikh</groupId>
            <artifactId>00102-base-jpa</artifactId>
            <version>v5.0</version>
        </dependency>
```
```
2.复制JPAConfig到新项目并修改以下参数
    //--001.这个是你Repositorie所在的包
    public static final String BASEPACKEAGE_REPOSITORY_SCAN = "com.swalikh.demo.quartz.repository";
    //--002.这个是你entity所在的包
    public static final String BASEPACKEAGE_ENTITY_SCAN = "com.swalikh.demo.quartz.entity";
    //--003.这个是你的datasource springboot默认是多数据源
    public static final String DATASOURCE = "spring.datasource.hikari";
```
```
3.复制yaml文件的配置到新项目配置文件并且修改
spring:
    application:
        name: pm-person-manager
    jpa:
        hibernate:
            ddl-auto: create
        show-sql: true
        database: mysql
    datasource:
        hikari:
            driver-class-name: com.mysql.cj.jdbc.Driver
            username: root
            password: 123456
            jdbc-url: jdbc:mysql://your-ip:3306}/database?useUnicode=true&characterEncoding=UTF8
```
```
4.测试接口
```
