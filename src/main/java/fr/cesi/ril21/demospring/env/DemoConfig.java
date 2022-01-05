package fr.cesi.ril21.demospring.env;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component // @Component  => allow class to be manged by Spring
@Getter // lombok
@Log
public class DemoConfig {

    @Value("${app.name}")
    private String appName;

    private Environment env;

    // Component's constructor only for DI
    @Autowired
    public DemoConfig(Environment env) {
        this.env = env;
    }

    @PostConstruct
    private void init() {
        log.info("Component DemoConfig is ready");
    }

}
