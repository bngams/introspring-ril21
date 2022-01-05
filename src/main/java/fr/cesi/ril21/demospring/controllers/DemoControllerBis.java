package fr.cesi.ril21.demospring.controllers;

import fr.cesi.ril21.demospring.env.DemoConfig;
import fr.cesi.ril21.demospring.services.DemoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController // @Controller + @ResponseBody
@Log
public class DemoControllerBis {

    private DemoService ds;
    private DemoConfig demoConfig;

    // Depdency Injection
    @Autowired // like @Inject
    public DemoControllerBis(DemoConfig demoConfig, DemoService demoService) {
        this.demoConfig = demoConfig;
        this.ds = demoService;
    }

    // @RequestMapping(value="/hello-bis", method = RequestMethod.GET)
    @GetMapping("/hello-bis")
    public String helloBis() {
        return "Hello world bis";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to " + this.demoConfig.getEnv().getProperty("app.name") + "!";
    }

    @GetMapping("/key-bis")
    public String displaykey() {
        return "Key is : " + this.ds.getKey() + "!";
    }

    @PostConstruct
    private void init() {
        log.info("Component DemoControllerBis is ready");
    }
}
