package com.iversonx.struts_springmvc.controller;

import com.iversonx.struts_springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Lijie
 * @version 1.0
 * @date 2020/1/9 10:46
 */
@Controller
@RequestMapping("/mvc")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/show.action")
    public String show(Model model,
                       @RequestParam(required = false, defaultValue = "Hello SpringMVC") String username,
                       @RequestParam(required = false, defaultValue = "123456") String password) {
        model.addAttribute("username", username);
        return "show";
    }

    @RequestMapping("/redirect.action")
    public String redirect() {
        return "redirect:/mvc/show.action";
    }

    @RequestMapping("/ajax1.action")
    public void ajax1() throws Exception{
        ServletRequestAttributes attr = (ServletRequestAttributes)
                RequestContextHolder.currentRequestAttributes();
        HttpServletResponse response = attr.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("HelloWorld");
        out.flush();
        out.close();
    }
}
