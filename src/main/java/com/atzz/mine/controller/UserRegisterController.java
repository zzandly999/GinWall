package com.atzz.mine.controller;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.Msg;
import com.atzz.mine.bean.UserRegisters;
import com.atzz.mine.mapper.DynamicInformationsMapper;
import com.atzz.mine.service.DynamicInformationsService;
import com.atzz.mine.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-03-24 20:09
 */
@Controller
public class UserRegisterController {

    @Autowired
    UserRegisterService userRegisterService;
    @Autowired
    HttpSession session;
    UserRegisters userRegister = new UserRegisters();
    @Autowired
    DynamicInformationsService dynamicInformationsService;
    HttpServletResponse response;

    /**
     * 去登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 去注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    /**
     * 查询所有用户的信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("getAllUsers")
    @ResponseBody
    public Msg getAllUsers(){
        List<UserRegisters> userRegisters = userRegisterService.selectAllUsers();
        if(userRegisters.isEmpty()){
            return Msg.fail();
        }
        return Msg.success().add("userList",userRegisters);
    }


    /**
     * 检查登录是否成功
     * @param
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/checkLogin", method = {RequestMethod.POST})
    @ResponseBody
    public List<UserRegisters> checkLogin(String nickName, String password, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<UserRegisters> userRegisters = userRegisterService.checkLogin(nickName, password);
        if(!userRegisters.isEmpty()){
            HttpSession session = request.getSession();
            session.setAttribute("userId",userRegisters.get(0).getId());
        }
        return userRegisters;
    }

    /**
     * 数据库校验用户名是否可用
     * @param nickName
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/checkNickname", method = {RequestMethod.POST})
    @ResponseBody
    public Msg checkNickname(String nickName){
        //正则表达式检验用户名是否合法
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!nickName.matches(regx)){
            return Msg.fail().add("fail_msg","用户名必须是6-16位数字和字母的组合或2-5位中文");
        }
        //数据库校验用户名是否重复
        boolean isAvailable = userRegisterService.checkRegisterNickname(nickName);
        if(isAvailable){
            return Msg.success();
        }else{
            return Msg.fail().add("fail_msg","用户名不可用");
        }
    }

    /**
     * 保存用户数据
     * @param
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/saveUserRegister", method = {RequestMethod.POST})
    public String saveUserRegister(MultipartFile avatar, String nickName, String password, String email,
                                String emailAuthentication, String mobile, String studentNumber,
                                HttpServletRequest request){
        //读取
        String path = request.getServletContext().getRealPath("/tx");
        System.out.println("物理路径：" + path);
        String filename = avatar.getOriginalFilename();
        File f = new File(new File(path),filename);
        if(!f.exists()){
            f.mkdirs();
        }
        try {
            avatar.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //显示
        String filepath = request.getServletContext().getRealPath("/tx/"+filename);
        File f2 = new File(filepath);
        userRegister.setAvatar("/tx/"+f2.getName());
        userRegister.setNickName(nickName);
        userRegister.setPassword(password);
        userRegister.setEmail(email);
        userRegister.setEmailAuthentication(emailAuthentication);
        userRegister.setMobile(mobile);
        userRegister.setStudentNumber(studentNumber);
        //错误
        if("".equals(nickName)){
            return "register";
        }
        if("".equals(password)){
            return "register";
        }
        if("".equals(email)){
            return "register";
        }
        if("".equals(emailAuthentication)){
            return "register";
        }
        if("".equals(mobile)){
            return "register";
        }
        if("".equals(studentNumber)){
            return "register";
        }
        userRegisterService.saveUserRegister(userRegister);
        return "login";
    }



}
