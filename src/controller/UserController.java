package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 2016/12/13.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping("/addUser")
    public String addUser5(User user) {
        System.out.println("userName is:"+user.getUsername());
        System.out.println("password is:"+user.getSex());
        return "/jsp/users/success";  //ajax提交的时候，页面不跳转，form提交的时候跳转，返回的结果就是页面的内容
    }
    @RequestMapping("/addUser4")
    public String addUser4(User user) {
        System.out.println("4userName is:"+user.getUsername());
        System.out.println("4sex is:"+user.getSex());
        return "/jsp/users/success";
    }
    @RequestMapping("/addUser3")
    public String addUser3(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("sex");
        System.out.println("33333userName is:"+userName);
        System.out.println("3333sex is:"+password);
        return "/jsp/users/success";
    }

    @RequestMapping("/addUser2")
    public String addUser1(String username,String sex) {
        System.out.println("22222userName is:"+username);
        System.out.println("22222sex is:"+sex);
        return "/jsp/users/success";
    }

    @RequestMapping("/form")
    public String userform() {
        return "/jsp/users/AddUser";
    }
}
