package com.zhangjiahui.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangjiahui.goods.mapper.OfficeMapper;
import com.zhangjiahui.goods.pojo.Officetool;
import com.zhangjiahui.goods.pojo.OfficetoolVo;
import com.zhangjiahui.goods.pojo.Types;
import com.zhangjiahui.goods.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    private OfficeMapper officeMapper;

    @Override
    public PageInfo<OfficetoolVo> selects(Integer pageNum, Integer pageSize, OfficetoolVo entity) {
        PageHelper.startPage(pageNum,pageSize);
        List<OfficetoolVo> officetools = officeMapper.selectObjects(entity);
        return new PageInfo<>(officetools);
    }

    @Override
    public List<Types> selectBytypes() {
        return officeMapper.selectBytypes();
    }

    @Override
    public int deleteByid(Integer id) {
        return officeMapper.deleteByid(id);
    }

    @Override
    public int insertObjects(Officetool entity) {
        int i=0;
        if (entity.getId()==null){
            i = officeMapper.insertObjects(entity);
        }else{
            i = officeMapper.updateObject(entity);
        }
        return i;
    }

    @Override
    public Officetool selectObjectById(Integer id) {
        return officeMapper.selectObjectById(id);
    }

    @Override
    public int updateObject(Officetool entity) {
        return officeMapper.updateObject(entity);
    }

    @Override
    public int deleteByids(String ids) {
        return officeMapper.deleteByids(ids);
    }
}
