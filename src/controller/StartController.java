package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vo.User;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

/**
 * Created by user on 2016/12/12.
 */
@Controller
@RequestMapping(value = "/welcome")
public class StartController {

    private static String START = "jsp/start";   //最初的写成"/views/jsp/start" 报错，因为dispatcher-servlet.xml中配置的目录为/WEB-INF/views/

    @RequestMapping(value="/index")
    public String start(HttpServletRequest request) {
        return START;
    }


    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";
    }

    @RequestMapping(value="/getPerson") //添加,produces = "text/plain;charset=UTF-8"不起作用
    public void getPerson(String name,String sex,PrintWriter pw){ //异步提交的方式
        System.out.println(name+":"+sex);
        pw.write("hello,"+name+":"+sex);

    }
    @RequestMapping(value="/getUser")
    public void getUser(@ModelAttribute User user,PrintWriter pw){
        System.out.println("------"+user.getUsername()+":"+user.getSex());

        pw.write("hello,"+user.getUsername());
    }
}
