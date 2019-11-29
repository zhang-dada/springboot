package com.zhangjiahui.goods.controller;

import com.github.pagehelper.PageInfo;
import com.zhangjiahui.goods.pojo.Officetool;
import com.zhangjiahui.goods.pojo.OfficetoolVo;
import com.zhangjiahui.goods.pojo.Types;
import com.zhangjiahui.goods.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Office")
public class OfficeController {
        @Autowired
        private OfficeService officeService;

        @RequestMapping("/list")
        public Object selectObjects(@RequestParam(value ="pageNum" ,defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize, OfficetoolVo entity){
            PageInfo<OfficetoolVo> selects = officeService.selects(pageNum, pageSize, entity);
            return selects;
        }

        @RequestMapping("/dele")
        public Object dele(Integer id){
            return officeService.deleteByid(id)>0;
        }
        @RequestMapping("/types")
        public Object selectBytypes(){
            List<Types> types = officeService.selectBytypes();
            return types;
        }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/deles")
    public Object deles(String ids){
        return officeService.deleteByids(ids)>0;
    }

    @RequestMapping("/insert")
    public Object insert(Officetool entity){
        return officeService.insertObjects(entity)>0;
    }

    @RequestMapping("/selectByid")
    public Object selectByid(Integer id){
        return officeService.selectObjectById(id);
    }

    @RequestMapping("/update")
    public Object update(Officetool entity){
        return officeService.updateObject(entity)>0;
    }
}
