package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@EnableWebMvc
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    // 配置了 Swagger 的 Docket 的 bean 实例
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的 Swagger 环境
        Profiles profiles = Profiles.of("dev", "test");

        // 通过 environment.acceptsProfiles 判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // enable: 是否启用 Swagger
                .groupName("hello world")
                .enable(flag)
                .select()
                // RequestHandlerSelectors. 配置要扫描接口的方式
                // basePackage: 指定文件夹扫描接口与实例
                // any: 扫描全部接口与实例
                // none: 不扫描接口与实例
                // withClassAnnotation: 扫描类上的注释, 参数是一个注释的反射对象
                // withMethodAnnotation: 扫描方法上的注释
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                // paths: 要过滤那些路径 (example -> .paths(PathSelectors.ant("/swagger/**")))
                .paths(PathSelectors.any())
                .build();
    }

    // 配置 Swagger 信息 -> apiInfo
    private ApiInfo apiInfo() {

        // 作者信息
        Contact contact = new Contact("minggang.li", "http://xxx.xxx.com", "xxxx@xxx.com");

        return new ApiInfo(
                "xxx 的 Swagger API 文档",
                "Swagger API 文档的描述信息",
                "v1.0",
                "藿香正气",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
