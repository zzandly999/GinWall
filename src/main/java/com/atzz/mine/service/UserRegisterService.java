package com.atzz.mine.service;

import com.atzz.mine.bean.UserRegisters;
import com.atzz.mine.bean.UserRegistersExample;
import com.atzz.mine.mapper.UserRegistersMapper;
import com.atzz.mine.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 20:10
 */
@Service
public class UserRegisterService {

    @Autowired
    UserRegistersMapper userRegistersMapper;

    /**
     * 查询所有的用户信息
     * @return
     */
    public List<UserRegisters> selectAllUsers(){
        return userRegistersMapper.selectByExample(null);
    }


    /**
     * 根据用户名查询
     * @param nickname
     * @return
     */
    public List<UserRegisters> selectByNickname(String nickname){
        UserRegistersExample example = new UserRegistersExample();
        UserRegistersExample.Criteria criteria = example.createCriteria();
        criteria.andNickNameEqualTo(nickname);
        List<UserRegisters> userRegisters = userRegistersMapper.selectByExample(example);
        return userRegisters;
    }


    /**
     * 数据库校验用户是否存在（根据用户名和密码）
     * @param nickname
     * @param password
     * @return null：不存在，反之则存在
     */
    public List<UserRegisters> checkLogin(String nickname, String password){
        UserRegistersExample example = new UserRegistersExample();
        UserRegistersExample.Criteria criteria = example.createCriteria();
        criteria.andNickNameEqualTo(nickname).andPasswordEqualTo(password);
        List<UserRegisters> users = userRegistersMapper.selectByExample(example);
//        List<UserRegisters> userRegisters = selectByNickname(users.get(0).getNickName());
//        Long id = userRegisters.get(0).getId();
        UserRegisters userRegisters = new UserRegisters();
        return users;
    }


    /**
     * 数据库校验用户名是否可用
     * @param nickName
     * @return true：可用，false：不可用
     */
    public boolean checkRegisterNickname(String nickName) {
        UserRegistersExample example = new UserRegistersExample();
        UserRegistersExample.Criteria criteria = example.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        long userRegisters = userRegistersMapper.countByExample(example);
        return userRegisters == 0;
    }

    /**
     * 保存用户
     * @param userRegister
     */
    public void saveUserRegister(UserRegisters userRegister) {
        UserRegisters userRegister1 = new UserRegisters(null, TimeUtils.currentTime(new Date()),TimeUtils.currentTime(new Date())
                ,null,userRegister.getMobile(),userRegister.getNickName(),userRegister.getAvatar(),userRegister.getStudentNumber()
                ,userRegister.getEmail()
                ,userRegister.getPassword(),null,null,null,null
                , userRegister.getEmailAuthentication(),null,null,null);
        userRegistersMapper.insertSelective(userRegister1);
    }



}
