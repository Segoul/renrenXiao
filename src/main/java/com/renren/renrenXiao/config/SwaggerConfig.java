package com.renren.renrenXiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//地址http://localhost:xxxx/swagger-ui.html
@Configuration  //通过@Configuration注解，让Spring来加载该类配置
@EnableSwagger2  //通过@EnableSwagger2注解来启用Swagger2
public class SwaggerConfig {

	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) //创建Api基本信息，可省略
                .select()  //选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.renren.renrenXiao"))  // 对所有api进行监控，
                .paths(PathSelectors.any())  // 对所有路径进行监控
                .build();
    }
	
	/**
	 * 创建Api基本信息，这些信息会展示在文档页面中
	 * 非必要
	 * @return
	 */
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("人人销名片")
                .termsOfServiceUrl("https://weibo.com/yylovedmr1314/home?wvr=5")
                .contact("人人销名片")
                .version("1.0")
                .build();
    }
}
