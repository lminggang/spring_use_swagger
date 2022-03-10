# Using swagger in spring boot

## 参考文章

* [【狂神说Java】一小时掌握Swagger技术](https://www.bilibili.com/video/BV1Y441197Lw?p=1)
* [Swagger3.0介绍及springboot整合Swagger3.0](https://blog.csdn.net/qq_43521797/article/details/115835771)
* [SpringBoot集成swagger后出现: Failed to start bean ‘documentationPluginsBootstrapper‘的解决方法](https://www.cnblogs.com/rainbow70626/p/15680184.html)

## 本地环境

* IDEA
* JDK 1.8
* Java 8

## 项目说明

新建 Spring Boot 项目后, 新增/修改 代码

* `src/main/java/com/example/swagger/config/SwaggerConfig.java` Swagger 全局控制
* `src/main/java/com/example/swagger/controller/HelloController.java` 测试接口文档标书示例
* `src/main/java/com/example/swagger/pojo/User.java` 测试实例文档描述示例
* `src/main/resources/application.properties` 项目配置文件
* `src/main/resources/application-dev.properties` 测试环境配置文件
* `src/main/resources/application-prod.properties` 生产环境测试文件
* `pom.xml`

## 运行项目

使用 IDEA 打开项目, 等待依赖加载完成后启动项目

## 测试

项目启动后, 打开浏览器输入地址

* [测试环境地址 http://127.0.0.1:8081/swagger-ui/index.html](http://127.0.0.1:8081/swagger-ui/index.html)
* [生产环境地址 http://127.0.0.1:8082/swagger-ui/index.html](http://127.0.0.1:8082/swagger-ui/index.html)

### 生产/测试环境切换

修改 `application.properties` 来进行切换

* dev: 测试环境(测试环境下可以看到文档)
* prod: 生产环境(生产环境下默认关闭了文档, 如果需要则修改 `SwaggerConfig.java` 文件中 `enable` 字段来进行控制)
