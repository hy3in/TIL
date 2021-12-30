package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Controller가 static file보다 우선순위가 높다.
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
