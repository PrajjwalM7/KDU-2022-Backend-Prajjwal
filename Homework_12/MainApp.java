package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.service.ActorService;
import com.example.utils.ObjectUtils;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ActorService service = context.getBean(ActorService.class);
        System.out.println(ObjectUtils.convertToJson(service.getFilmsByActor("Zero", "Cage")));
        System.out.println("\n=========================\n");
        System.out.println(ObjectUtils.convertToJson(service.getActorsByName("Zero", "Cage")));
        System.out.println("\n=========================\n");
        System.out.println(ObjectUtils.convertToJson(service.getActorsByID(10)));
    }
}
