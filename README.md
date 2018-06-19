# README

---

> spring-web-starter by maven

### settings

* start.spring.io中创建
![1](media/15293763418621/1.png)
![2](media/15293763418621/2.png)
![3](media/15293763418621/3.png)

* 这个选Enable Auto-Import

![4](media/15293763418621/4.png)

* 已经可以直接运行了 w

![5](media/15293763418621/5.png)

### Files

```bash
tree
.
├── mvnw
├── mvnw.cmd
├── pom.xml # 这个是配置文件
├── spring-boot-architecture.iml # intellij的配置文件
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── demo
│   │   │               └── DemoApplication.java # 主程序，main
│   │   └── resources   # 这里放配置信息
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test # 测试程序
│       └── java
│           └── com
│               └── example
│                   └── demo
│                       └── DemoApplicationTests.java # 测试代码
└── target # build可执行二进制代码
    ├── classes
    │   ├── application.properties
    │   └── com
    │       └── example
    │           └── demo
    │               └── DemoApplication.class
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    └── test-classes
        └── com
            └── example
                └── demo
                    └── DemoApplicationTests.class
```


