package com.atzz.mine.controller;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.Msg;
import com.atzz.mine.bean.UserRegisters;
import com.atzz.mine.service.DynamicInformationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 18:13
 */
@Controller
public class DynamicInformationsController {

    @Autowired
    DynamicInformationsService dynamicInformationsService;
    @Autowired
    HttpSession session = new MockHttpSession();
    DynamicInformations dynamicInformations = new DynamicInformations();

    //去首页
    @RequestMapping("/mine")
    public String index(){
        return "mine";
    }
    //去发布页面
    @RequestMapping("/sendComments")
    public String toSendComments(){
        return "sendComments";
    }
    //去我的发布页面
    @RequestMapping("/toMySend")
    public String toMySend(){
        return "mySend";
    }

    /**
     * 得到所有的动态
     * @return
     */
    @CrossOrigin
    @RequestMapping("/getAllComments")
    @ResponseBody
    public Msg getAll(){
        List<DynamicInformations> dynamicInformationsList = dynamicInformationsService.getAllComments();
        return Msg.success().add("comments",dynamicInformationsList);
    }
    /**
     * 得到所有带用户的动态
     * @return
     */
    @CrossOrigin
    @RequestMapping("/getAllCommentsWithUser")
    @ResponseBody
    public Msg getAllWithUser(){
        List<DynamicInformations> dynamicInformationsList = dynamicInformationsService.getAllCommentsWithUser();
        return Msg.success().add("commentsWithUser",dynamicInformationsList);
    }

    /**
     * 保存动态
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/saveComments")
    public String saveComment(MultipartFile cover, String comment,  String type,HttpServletRequest request){
        //读取
        String path = request.getServletContext().getRealPath("/images");
        System.out.println("物理路径：" + path);
        String filename = cover.getOriginalFilename();
        File f = new File(new File(path),filename);
        if(!f.exists()){
            f.mkdirs();
        }
        try {
            cover.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //显示
        String filepath = request.getServletContext().getRealPath("/images/"+filename);
        File f2 = new File(filepath);
        HttpSession session = request.getSession();
        long userId = (long)session.getAttribute("userId");
        System.out.println(userId);
        dynamicInformations.setUserRegisterId(userId);
        dynamicInformations.setCover("/images/"+f2.getName());
        dynamicInformations.setComment(comment);
        dynamicInformations.setType(type);
        int i = dynamicInformationsService.saveComments(dynamicInformations);
        if(i == 0){
            return null;
        }
        return "mine";
    }

    /**
     * 我的发布页面
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/mySendCommentsWithUser", method = {RequestMethod.GET})
    @ResponseBody
    public Msg mySendComments(HttpServletRequest request){
        HttpSession session = request.getSession();
        long userId = (long)session.getAttribute("userId");
        List<DynamicInformations> mySendComments = dynamicInformationsService.getMySendCommentsWithUser(userId);
        if(mySendComments.isEmpty()){
            return Msg.fail();
        }
        return Msg.success().add("myCommentsWithUser",mySendComments);
    }

    /**
     * 去who的主页
     * @param nickName
     * @return
     */
    @RequestMapping(value = "/toWho", method = {RequestMethod.POST})
    @ResponseBody
    public Msg toWho(String nickName, HttpServletRequest request){
        List<UserRegisters> whoComment = dynamicInformationsService.getWhoComment(nickName);
        if(whoComment.isEmpty()){
            return Msg.fail();
        }
        HttpSession session = request.getSession();
        session.setAttribute("whoComment",whoComment);
        return Msg.success().add("whoComment",whoComment);
    }

    /**
     * 展示详情
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/toShowDetails", method = {RequestMethod.POST})
    @ResponseBody
    public Msg toShowDetails(Long id, HttpServletRequest request){
        DynamicInformations dynamicInformations = dynamicInformationsService.showDetails(id);
        HttpSession session = request.getSession();
        session.setAttribute("showDetails", dynamicInformations);
        return Msg.success().add("showDetails", dynamicInformations);
    }

    /**
     * 搜索
     * @param type
     * @param request
     * @return
     */
    @RequestMapping(value = "/searchDetails", method = {RequestMethod.POST})
    @ResponseBody
    public Msg toSearch(String type, HttpServletRequest request){
        List<DynamicInformations> dynamicInformationsList = dynamicInformationsService.showSearch(type);
        HttpSession session = request.getSession();
        session.setAttribute("searchDetails",dynamicInformationsList);
        return Msg.success().add("searchDetails",dynamicInformationsList);
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @RequestMapping(value = "/like", method = {RequestMethod.POST})
    @ResponseBody
    public Msg toLike(Long id){
        dynamicInformationsService.addLike(id);
        return Msg.success();
    }


}
