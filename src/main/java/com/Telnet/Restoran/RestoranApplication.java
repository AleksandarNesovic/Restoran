package com.Telnet.Restoran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestoranApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestoranApplication.class, args);
	}

	 @Bean
	 public Docket api() {

	        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.Telnet.Restoran.controller"))
	                .paths(PathSelectors.any()).build().securitySchemes(Collections.singletonList(securitySchema()))
	                .securityContexts(Collections.singletonList(securityContext())).pathMapping("/")
	                .useDefaultResponseMessages(false).apiInfo(apiInfo());
	    }
	 
	 private OAuth securitySchema() {

	        List<AuthorizationScope> authorizationScopeList = new ArrayList<AuthorizationScope>();

	        List<GrantType> grantTypes = new ArrayList<GrantType>();
	        GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant("http://localhost:8080/Restoran/webapi/clients/login");

	        grantTypes.add(creGrant);
	        
	        return new OAuth("Authorization", authorizationScopeList, grantTypes);

	    }

	 private SecurityContext securityContext() {
	        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.ant("/*"))
	                .build();
	    }
	 private List<SecurityReference> defaultAuth() {
    	 AuthorizationScope authorizationScope
         = new AuthorizationScope("global", "accessEverything");
     AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
     authorizationScopes[0] = authorizationScope;
     
     List<SecurityReference> list = new ArrayList<>();
     
     System.out.println("authorizationScopes: "+authorizationScopes);
     
     list.add(  new SecurityReference("Bearer", authorizationScopes));
     return list;

    }
	 
	 private ApiInfo apiInfo() {
	        return new ApiInfoBuilder().title("TELNET RESTORAN APIs").description("")
	                .termsOfServiceUrl("https://www.example.com/api")
	                .contact(new Contact("Hasson", "http://www.example.com", "hasson@example.com"))
	                .license("Open Source").licenseUrl("https://www.example.com").version("1.0.0").build();
	    }
}
