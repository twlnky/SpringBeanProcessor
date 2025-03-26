package rut.miit.tech.springbeanprocessor.components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import java.util.Random;


@Configuration
public class AppConfig {

    @Bean(name = "hello")
    public String helloWorld(){
        return "";
    }

    @Primary
    @Bean(name = "goodbye")
    public String goodbyeWorld(){
        return "";
    }

    @Scope(scopeName = "prototype")
    @Bean
    public Integer randomInt(){
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt();
    }

}
