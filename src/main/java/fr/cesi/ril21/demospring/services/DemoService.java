package fr.cesi.ril21.demospring.services;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

// @Component
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Getter
@Log
public class DemoService {

    private Integer key;

    // only for DI
    public DemoService() {}

    @PostConstruct
    private void init() {
        this.key = new Random().nextInt();
        log.info("DemoService ready with key :" + this.key);
    }

}
