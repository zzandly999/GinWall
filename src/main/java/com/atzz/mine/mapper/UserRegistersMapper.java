package com.atzz.mine.mapper;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.UserRegisters;
import com.atzz.mine.bean.UserRegistersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRegistersMapper {
    long countByExample(UserRegistersExample example);

    int deleteByExample(UserRegistersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRegisters record);

    int insertSelective(UserRegisters record);

    List<UserRegisters> selectByExample(UserRegistersExample example);

    UserRegisters selectByPrimaryKey(Long id);

    /**
     * 新增
     * @param nickName
     * @return
     */
    List<UserRegisters> selectCommentsByNickname(String nickName);

    int updateByExampleSelective(@Param("record") UserRegisters record, @Param("example") UserRegistersExample example);

    int updateByExample(@Param("record") UserRegisters record, @Param("example") UserRegistersExample example);

    int updateByPrimaryKeySelective(UserRegisters record);

    int updateByPrimaryKey(UserRegisters record);
}