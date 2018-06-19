# README

---

> spring-web-starter by gradle

### settings

![1](media/15293763418621/1.png)
![2](media/15293763418621/2.png)
![3](media/15293763418621/3.png)
![4](media/15293763418621/4.png)
![5](media/15293763418621/5.png)

* 直接运行报错, classpath找不到

    ```bash
    $ ./gradlew build
    ```

* 显示配置

![6](media/15293763418621/6.png)
![7](media/15293763418621/7.png)

* 显示model的依存关系

![8](media/15293763418621/8.png)
![9](media/15293763418621/9.png)


### Files

```bash
$ tree
.
├── build.gradle # 主要的配置文件
├── gradle  # 自动生成的文件
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat # 自动生成的文件
├── out # build成果物
│   └── production
│       ├── classes
│       │   └── com
│       │       └── example
│       │           └── demo
│       │               └── DemoApplication.class
│       └── resources
│           └── application.properties
├── settings.gradle # 一些环境变量
└── src # src以下的目录结构
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── demo
    │   │               └── DemoApplication.java # 主程序
    │   └── resources # 主程序配置
    │       ├── application.properties # 程序的配置信息
    │       ├── static
    │       └── templates
    └── test # 测试
        ├── java
        │   └── com
        │       └── example
        │           └── demo
        │               └── DemoApplicationTests.java
        └── resources
```


