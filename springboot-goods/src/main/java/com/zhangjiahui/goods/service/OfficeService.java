package com.zhangjiahui.goods.service;

import com.github.pagehelper.PageInfo;
import com.zhangjiahui.goods.pojo.Officetool;
import com.zhangjiahui.goods.pojo.OfficetoolVo;
import com.zhangjiahui.goods.pojo.Types;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfficeService {
    PageInfo<OfficetoolVo> selects(Integer pageNum, Integer pageSize, OfficetoolVo entity);


    List<Types> selectBytypes();

    int deleteByid(Integer id);

    int insertObjects(Officetool entity);

    Officetool selectObjectById(Integer id);

    int updateObject(Officetool entity);

    int deleteByids(String ids);
}
