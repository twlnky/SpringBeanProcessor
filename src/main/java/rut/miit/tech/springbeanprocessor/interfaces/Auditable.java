package rut.miit.tech.springbeanprocessor.interfaces;

import org.springframework.beans.factory.annotation.Autowired;

public interface Auditable {
    void audit();


    default void doDefauult(@Autowired Auditable auditable){
        System.out.println(auditable);
    }
}
