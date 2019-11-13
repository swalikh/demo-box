### Websocket服务器的整合步骤

#### 1.添加pom依赖

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-websocket</artifactId>
            <version>2.0.2.RELEASE</version>
        </dependency>
```

#### 2.复制websocket的configuration配置文件

```java
   public class Websocketconfig{
        @Bean  
        public ServerEndpointExporter serverEndpointExporter(){  
            return new ServerEndpointExporter();  
        }  
   }
```

#### 3.建立Websocket用户信息实体和服务器

​	复制实体和server到工程中

#### 4. 注入server使用相关的方法

​	在controller中用相应的方法来发送消息，接受消息等等.......