package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
    
    /*
    * MVC와 템플릿 엔진 
    */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    /*
    * ResponseBody를 사용한 API방식
    * ResponseBody가 있으면 BODY에 객체나 문자를 직접반환
    * 원래는 Controller에서 ViewResolver에게 던지지만 HttpMessageConverter로 객체를 넘김
    * (객체: JsonConverter - MappingJackson2HttpMessageConverter 문자: StringConverter - StringHttpMessageConverter)
    * 객체가 오면 json방식으로 데이터를 만들어서 http응답에 반환
    * 실무에선 이거 손대지 않고 거의 그대로 씀..
    */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        //ctrl + shift + enter 단축키
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //json으로 반환
    }

    static class Hello{
        private String name;

        //art+insert 단축키로 생성가능
       public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
