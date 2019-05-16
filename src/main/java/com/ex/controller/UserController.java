package com.ex.controller;



import com.ex.entity.EUser;
import com.ex.entity.Sendmail;
import com.ex.mail.SendEmail;
import com.ex.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/addUser")
    public  String addUser(EUser user){
         userService.insert(user);
        return  "index";
    }
    @RequestMapping("/login")
    public  String login(String username, String password, ModelMap map){
        EUser user=userService.login(username,password);
        if (user ==null ){
             map.put("msg", "账户密码不正确");
            return "index";
        }else {
            return "hello";
        }

    }
    @RequestMapping("register1")
    public  String register(EUser user,ModelMap map){
        //存到数据中
        try {
            userService.insert(user);
            System.out.println("把用户信息注册到数据库中");
            Sendmail sendmail=new Sendmail(user);
            //启动线程，线程启动之后就会执行run方法来发送邮件
            sendmail.start();
            map.put("message","恭喜您，注册成功，我们已经发了一封带了注册信息的电子邮件，请查收，如果没有收到，可能是网络原因，过一会儿就收到了！！");
            return "index";
        }catch (Exception e){
              map.put("message","注册失败");
              return "index";
        }
    }
    @RequestMapping(value = "/getMail",produces = "text/html;charset=utf8")
    @ResponseBody
    public void getEmail(@RequestParam("mail") String mail, HttpServletRequest request) throws Exception {

        int num = (int) (Math.random()*9000+1000);

        String code = String.valueOf(num);

        SendEmail.SendEmailInfoUser(mail, "您收到一个验证码", code, "");

        request.getSession().setAttribute("code", code);

    }
    @RequestMapping(value = "/register")
    public String register(EUser user, HttpServletRequest request, ModelMap map) {

        String code = (String) request.getSession().getAttribute("code");

        if(!code.equals(user.getCode())){
            map.put("message", "验证码输入不正确");
            return "register";
        }else {
            int result =  userService.register(user);
            return "index";
        }
    }
    @RequestMapping(value = "/getpass")
    public String  getpass(String username) throws Exception {
        EUser user = userService.getpass(username);
        String mail = user.getMail();
        SendEmail.SendEmailInfoUser(mail, "邮件的标题",
                "http://127.0.0.1:8080/user/resetpass?id="+user.getId(), "");
        return "index";
    }
    @RequestMapping(value = "/resetpass")
    public String resetpass(Integer id,ModelMap map) {
        EUser user = userService.selectUserById(id);
        map.put("user", user);
        return "update";
    }
    @RequestMapping(value = "/update")
    public String update(EUser user) {
        int result = userService.update(user);
        return "index";
    }

}
