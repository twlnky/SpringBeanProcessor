package rut.miit.tech.springbeanprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("Запуск приложения...");
        SpringApplication.run(Application.class, args);
        System.out.println("Приложение завершило работу");
    }
}