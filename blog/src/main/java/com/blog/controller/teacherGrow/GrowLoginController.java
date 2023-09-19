package com.blog.controller.teacherGrow;

import com.blog.pojo.Teacher;
import com.blog.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/grow")
public class GrowLoginController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping()
    public String loginPage(){
        return "grow/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String teachername,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        Teacher teacher = teacherService.checkTeacher(teachername, password);
        if(teacher != null){
            teacher.setPassword(null);
            session.setAttribute("teacher", teacher);
            return "grow/index";
        }else {
            attributes.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/grow";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("teacher");
        return "redirect:/grow";
    }
}
