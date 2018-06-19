# Commit-Diff


### maven vs gradle

#### Files

1. [maven](https://github.com/ztp1977/spring-boot-architecture/compare/master...master-starter-web-m?expand=1&w=1) - maven的配置

    ```xml
    <!-- namespace -->
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <!-- 2. build setting -->
        <groupId>com.example</groupId>
        <artifactId>demo</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <packaging>jar</packaging>

        <!-- 3. project name -->
        <name>demo</name>
        <description>Demo project for Spring Boot</description>

        <!-- 4. inherit relation -->
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.0.3.RELEASE</version>
            <relativePath/> <!-- lookup parent from repository -->
        </parent>

        <!-- 5. project properties -->
        <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
            <java.version>1.8</java.version>
        </properties>

        <!-- 6. project dependencies -->
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-test</artifactId>
                <scope>test</scope>
            </dependency>
        </dependencies>
        
        <!-- 7. build plugin -->
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                </plugin>
            </plugins>
        </build>

    </project>
    ```
2. [gradle](https://github.com/ztp1977/spring-boot-architecture/compare/master...master-starter-web-g?expand=1#diff-c197962302397baf3a4cc36463dce5ea) - gradle的配置

    ```groovy
    # build.gradle
    # 4， 7.) 创建用
    buildscript {
        ext {
            springBootVersion = '2.0.3.RELEASE'
        }
        # 下载地址
        repositories {
            mavenCentral()
        }
        # 这个文件夹以下的都会被导入
        dependencies {
            classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        }
    }

    # 4. plugins
    apply plugin: 'java'
    apply plugin: 'eclipse'
    apply plugin: 'org.springframework.boot'
    apply plugin: 'io.spring.dependency-management'

    # 2~3 project属性
    group = 'com.example'
    version = '0.0.1-SNAPSHOT'
    sourceCompatibility = 1.8

    repositories {
        mavenCentral()
    }

    # 6.) 依赖关系
    dependencies {
        compile('org.springframework.boot:spring-boot-starter-web')
        testCompile('org.springframework.boot:spring-boot-starter-test')
    }
    ```

[TOC]



