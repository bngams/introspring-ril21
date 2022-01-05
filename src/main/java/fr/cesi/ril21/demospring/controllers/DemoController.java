package fr.cesi.ril21.demospring.controllers;

import fr.cesi.ril21.demospring.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// servlet (claass map to urls)
// @Component => class managed by Spring => Spring Bean
@Controller
public class DemoController {

    private DemoService ds;

    @Autowired
    public DemoController(DemoService ds) {
        this.ds = ds;
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    // HTTP GET /key => display the service key
    @RequestMapping(value="/key", method = RequestMethod.GET)
    @ResponseBody
    public String displayKey() {
        return "Key is :" + this.ds.getKey();
    }
}
