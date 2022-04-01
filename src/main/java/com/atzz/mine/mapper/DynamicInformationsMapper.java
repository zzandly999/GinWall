package com.atzz.mine.mapper;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.DynamicInformationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicInformationsMapper {
    long countByExample(DynamicInformationsExample example);

    int deleteByExample(DynamicInformationsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DynamicInformations record);

    int insertSelective(DynamicInformations record);

    List<DynamicInformations> selectByExample(DynamicInformationsExample example);

    DynamicInformations selectByPrimaryKey(Long id);

    /**
     * 新增
     * @return
     */
    List<DynamicInformations> selectWithUserRegisters();

    /**
     * 新增
     * @param userRegisterId
     * @return
     */
    List<DynamicInformations> selectByUserRegistersIdWithUser(Long userRegisterId);

    /**
     * 新增
     * @param id
     * @return
     */
    DynamicInformations selectByPrimaryKeyWithUser(Long id);

    /**
     * 新增
     * @param type
     * @return
     */
    List<DynamicInformations> searchByAny(String type);

    int updateByExampleSelective(@Param("record") DynamicInformations record, @Param("example") DynamicInformationsExample example);

    int updateByExample(@Param("record") DynamicInformations record, @Param("example") DynamicInformationsExample example);

    int updateByPrimaryKeySelective(DynamicInformations record);

    int updateByPrimaryKey(DynamicInformations record);
}