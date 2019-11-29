package com.zhangjiahui.goods;

import com.zhangjiahui.goods.mapper.OfficeMapper;
import com.zhangjiahui.goods.pojo.Officetool;
import com.zhangjiahui.goods.service.OfficeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testDemo {
    @Autowired
    private OfficeMapper officeMapper;

    @Test
    public void show(){

    }
}
