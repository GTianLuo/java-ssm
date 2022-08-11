package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping("/a")
    public String success(){
        //System.out.println(1 / 0);

        String s = null;
        s.charAt(1);
        return "success";
    }
}
