# 一个简单的web-service

---

### Concepts
1. **DI** - Bean, Container，JUNIT其实都是DI的应用
2. **Annotation** - 元数据编程? 听起来高大上呀，参考: [1](https://blog.csdn.net/lylwo317/article/details/52163304)
3. context - 全体
4. @Controller - 路由，param，启动服务, 传递给view (presenter)
5. @Service - 业务逻辑, 连接model，repository
6. model - is class for representing [POJO](https://spring.io/understanding/POJO)
7. @Repository - 通过DAO对DB进行操作的层
8. entity - relation to db， 有点儿像schema
9. @Component - Bean登录到DI Container
10. @Bean - 可以通过@Autowired注入
11. [properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html) - 这个网页的属性都可以设定的

### Tasks
* [x] 建一个简单的web服务
* [x] 有一个简单的controller
* [x] 有一个简单的model
* [x] 可以连接mysql，做简单的CRUD操作
* [ ] 可以测试JUNIT
* [ ] 可以输出docs

### Dependencies
1. [propdeps-plugin](https://github.com/spring-gradle-plugins/propdeps-plugin) - Bean设定值检索的工具
    
    ```bash
    # 设定完了以后， 执行下面语句
    $ gradle idea
    ```
2. JPA - ORM
3. hibernate - ORM
4. mysql:mysql-connector-java - mysql的库
5. **spring-restdocs-mockmvc** - docs & test

### 设定

1. 这个文件可以改Bean的设定

```bash
$ cat src/main/resources/application.properties

# mysql
spring.datasource.url=jdbc:mysql://localhost:3306/spring_db?useSSL=false
spring.datasource.username=root

# JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update # 这个是自动建表的设置
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect # hibernate_sequence 这个表不知道干啥用的
```

### Files

```bash
$ tree
.
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── out
│   └── production
│       ├── classes
│       │   └── com
│       │       └── example
│       │           └── simplewebservice
│       │               ├── SimpleWebServiceApplication.class
│       │               ├── controllers
│       │               │   ├── MainController.class
│       │               │   └── UserController.class
│       │               └── models
│       │                   ├── User.class
│       │                   └── UserDao.class
│       └── resources
│           └── application.properties
├── settings.gradle
├── simple-web-service.iml
├── simple-web-service.ipr
├── simple-web-service.iws
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── simplewebservice
    │   │               ├── SimpleWebServiceApplication.java
    │   │               ├── controllers
    │   │               │   ├── MainController.java
    │   │               │   └── UserController.java
    │   │               └── models
    │   │                   ├── User.java
    │   │                   └── UserDao.java
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       └── templates
    └── test
        ├── java
        │   └── com
        │       └── example
        │           └── simplewebservice
        │               └── SimpleWebServiceApplicationTests.java
        └── resources
```

### db - ddl 自动生成

```bash
$ mysql -uroot -e 'show tables' spring_db;
+---------------------+
| Tables_in_spring_db |
+---------------------+
| hibernate_sequence  |
| users               |
+---------------------+
```

### Think about
1. spring boot的好处是写好了很多插件， 配置就可以用
2. 通过自动加载的方式， 可以实现热加载
3. @annotation还得深挖挖
4. gradle javadoc - 可以自动生成文档， spring boot的生态总体来说不错。


