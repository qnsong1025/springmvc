package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by user on 2016/12/16.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String Login(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession httpSession){
        String result_page;
        if("songqn".equals(username)&&"songqn".equals(password)){
            result_page="index";
            httpSession.setAttribute("username", username);
        }else {
            result_page="error";
        }

        return result_page;
    }
}
