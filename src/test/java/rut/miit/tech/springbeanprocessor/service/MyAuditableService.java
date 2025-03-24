package rut.miit.tech.springbeanprocessor.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import rut.miit.tech.springbeanprocessor.annotations.LoggingClass;
import rut.miit.tech.springbeanprocessor.annotations.LoggingMethod;
import rut.miit.tech.springbeanprocessor.interfaces.Auditable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
@LoggingClass
@Service
public class MyAuditableService implements Auditable {
    private int[] data;

    @PostConstruct
    public void initData() {
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = random.nextInt(100);
        }
        System.out.println("Массив инициализирован: " + Arrays.toString(data));
    }
    @LoggingMethod
    public void sortedData(Comparator<Integer> comparator){
        IntStream stream = Arrays.stream(data);
        try {
            data = stream.boxed()
                    .sorted(comparator)
                    .mapToInt(Integer::intValue)
                    .toArray();
        } catch (Exception e) {
            throw new RuntimeException("Sorted Filed "+e);
        }
    }

    @Override
    public void audit() {
        System.out.println("Аудит данных: " + Arrays.toString(data));
    }
}