package com.atzz.mine.service;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.DynamicInformationsExample;
import com.atzz.mine.bean.UserRegisters;
import com.atzz.mine.bean.UserRegistersExample;
import com.atzz.mine.mapper.DynamicInformationsMapper;
import com.atzz.mine.mapper.UserRegistersMapper;
import com.atzz.mine.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 18:16
 */
@Service
public class DynamicInformationsService {

    @Autowired
    DynamicInformationsMapper dynamicInformationsMapper;
    @Autowired
    UserRegistersMapper userRegistersMapper;

    /**
     * 查询所有的动态
     * @return null：查询失败
     */
    public List<DynamicInformations> getAllComments(){
        List<DynamicInformations> dynamicInformationsList = dynamicInformationsMapper.selectByExample(null);
        for(DynamicInformations dy: dynamicInformationsList){
            Date updateTime = dy.getUpdateTime();
            java.sql.Date sql = new java.sql.Date(updateTime.getTime());
            dy.setUpdateTime(sql);
        }
        return dynamicInformationsList;
    }

    /**
     * 查询所有带用户的动态
     * @return
     */
    public List<DynamicInformations> getAllCommentsWithUser(){
        List<DynamicInformations> dynamicInformationsList = dynamicInformationsMapper.selectWithUserRegisters();
        for(DynamicInformations dy: dynamicInformationsList){
            Date updateTime = dy.getUpdateTime();
            java.sql.Date sendTime = new java.sql.Date(updateTime.getTime());
            dy.setUpdateTime(sendTime);
        }
        return dynamicInformationsList;
    }

    /**
     * 保存动态
     * @param dynamicInformations
     * @return
     */
    public int saveComments(DynamicInformations dynamicInformations){
        String url = "";
        if("表白".equalsIgnoreCase(dynamicInformations.getType())){
            url = "/love";
        }
        if("失物招领".equalsIgnoreCase(dynamicInformations.getType())){
            url = "/loseThing";
        }
        if("话题讨论".equalsIgnoreCase(dynamicInformations.getType())){
            url = "/talk";
        }
        if("请选择".equalsIgnoreCase(dynamicInformations.getType()) || dynamicInformations.getComment() == null || dynamicInformations.getComment().trim().equalsIgnoreCase("")){
            return 0;
        }
        DynamicInformations dynamicInformations1 = new DynamicInformations(null, TimeUtils.currentTime(new Date()), TimeUtils.currentTime(new Date()),
                null, null, null, null, url, dynamicInformations.getType(), null, null, null, dynamicInformations.getComment(),
                dynamicInformations.getCover(), dynamicInformations.getUserRegisterId());
        return dynamicInformationsMapper.insertSelective(dynamicInformations1);
    }

    /**
     * 获取我发布的动态
     * @param id
     * @return
     */
    public List<DynamicInformations> getMySendCommentsWithUser(Long id){
        List<DynamicInformations> dynamicInformationsList = dynamicInformationsMapper.selectByUserRegistersIdWithUser(id);
        for(DynamicInformations dy: dynamicInformationsList){
            Date updateTime = dy.getUpdateTime();
            java.sql.Date sendTime = new java.sql.Date(updateTime.getTime());
            dy.setUpdateTime(sendTime);
        }
        return dynamicInformationsList;
    }

    /**
     * 返回who的主页
     * @param nickName
     * @return
     */
    public List<UserRegisters> getWhoComment(String nickName){
        List<UserRegisters> dynamicInformationsList = userRegistersMapper.selectCommentsByNickname(nickName);
        for(UserRegisters user: dynamicInformationsList){
            DynamicInformations dynamicInformations = user.getDynamicInformations();
            Date updateTime = dynamicInformations.getUpdateTime();
            java.sql.Date sendTime = new java.sql.Date(updateTime.getTime());
            dynamicInformations.setUpdateTime(sendTime);
        }
        return dynamicInformationsList;
    }

    /**
     * 动态的详细信息
     * @param id
     * @return
     */
    public DynamicInformations showDetails(Long id){
        DynamicInformations dynamicInformations = dynamicInformationsMapper.selectByPrimaryKeyWithUser(id);
        Date updateTime = dynamicInformations.getUpdateTime();
        java.sql.Date sendTime = new java.sql.Date(updateTime.getTime());
        dynamicInformations.setUpdateTime(sendTime);
        return dynamicInformations;
    }

    /**
     * 模糊查询
     * @param type
     * @return
     */
    public List<DynamicInformations> showSearch(String type){
        List<DynamicInformations> dynamicInformationsList = dynamicInformationsMapper.searchByAny(type);
        for(DynamicInformations dy: dynamicInformationsList){
            Date updateTime = dy.getUpdateTime();
            java.sql.Date sendTime = new java.sql.Date(updateTime.getTime());
            dy.setUpdateTime(sendTime);
        }
        return dynamicInformationsList;
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    public Long addLike(Long id){
        DynamicInformations dynamicInformations = dynamicInformationsMapper.selectByPrimaryKey(id);
        Long like = dynamicInformations.getLike();
        like = like + 1;
        dynamicInformations.setLike(like);
        dynamicInformationsMapper.updateByPrimaryKeySelective(dynamicInformations);
        return like;
    }


}
