package rut.miit.tech.springbeanprocessor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rut.miit.tech.springbeanprocessor.service.MyAuditableService;

import java.util.Comparator;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private final MyAuditableService auditableService;

    public ApplicationRunner(MyAuditableService auditableService) {
        this.auditableService = auditableService;
    }

    @Override
    public void run(String... args) throws Exception {
        auditableService.sortedData(Comparator.naturalOrder());
        auditableService.audit();
    }
}
