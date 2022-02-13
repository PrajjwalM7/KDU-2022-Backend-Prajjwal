package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        ActorService service = context.getBean(ActorService.class);
//        FilmService service1 = context.getBean(FilmService.class);
//        System.out.println(ObjectUtils.convertToJson(service1.getFilmsByActor("Zero", "Cage")));
//        System.out.println("\n=========================\n");
//        System.out.println(ObjectUtils.convertToJson(service.getActorsByName("Zero", "Cage")));
//        System.out.println("\n=========================\n");
//        System.out.println(ObjectUtils.convertToJson(service.getActorsByID(10)));gg
    }
}
