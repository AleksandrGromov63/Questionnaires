package ru.ocode.questionnaires.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

}

/*    @Bean
    @Description("Thymeleaf Template Resolver")
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);

        return templateResolver;
    }

    @Bean
    @Description("Thymeleaf Template Engine")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    @Description("Thymeleaf View Resolver")
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(1);
        return viewResolver;
    }*/

 /*   <!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="https://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<div class="form-structor">
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <div sec:authorize="!isAuthenticated()" class="signup">
        <h3>GKHJHKJH</h3>
        <h2 class="form-title" id="signup">Sign up</h2>
        <div  class="form-holder">

            <!--*//*@thymesVar id="userForm" type="ru.ocode.questionnaires.model.User"*//*-->
            <form th:method="POST" th:action="@{/registration}" th:object="${userForm}" >


         <!--      <input type="text" class="input" placeholder="Name" th:field="*{username}"/>-->
                <!--*//*@thymesVar id="password" type="java.lang.String"*//*-->
                <input type="text" class="input" placeholder="Password" th:text="${userForm.username}"/>

                <input type="text" class="input" placeholder="Confirm password" />
            </form>
            <input type="submit">Sign Up</input>

            <form method="post" action="registration.ftlh" ></form>
        </div>
    </div>
    <!--  <div sec:authorize="isAuthenticated()">
          <h4><a href="/logout" style="color:orangered">Выйти</a></h4>
      </div>
      <div class="login">
          <div class="center">
              <h2 class="form-title" id="login">Log in</h2>
              <div class="form-holder">
                  <input type="text" class="input" placeholder="Name"/>
                  <input type="text" class="input" placeholder="Password"/>
              </div>
              <button class="submit-button">Log in</button>
          </div>
      </div>-->
</div>
</body>
</html>*/

