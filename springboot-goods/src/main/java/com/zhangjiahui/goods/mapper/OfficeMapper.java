package com.zhangjiahui.goods.mapper;

import com.zhangjiahui.goods.pojo.Officetool;
import com.zhangjiahui.goods.pojo.OfficetoolVo;
import com.zhangjiahui.goods.pojo.Types;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OfficeMapper {
    List<OfficetoolVo> selectObjects(@Param("entity") OfficetoolVo entity);

    @Select("select * from t_type")
    List<Types> selectBytypes();
    @Delete("delete  from t_officetool where id=#{id}")
    int deleteByid(@Param("id") Integer id);

    int insertObjects(@Param("entity") Officetool entity);

    @Select("select * from t_officetool where id=#{id}")
    Officetool selectObjectById(@Param("id") Integer id);

    int updateObject(@Param("entity") Officetool entity);

    @Delete("delete from t_officetool where id in (${ids})")
    int deleteByids(@Param("ids") String ids);
}
