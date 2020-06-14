package com.chenyj.market.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/6/13 0013
 * 陈银杰专属测试
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * @desc: 自定义插入数据时修改数据
     * @author: chenyj
     * @date:  2020/6/13 0013
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("version", 1, metaObject);
        this.setFieldValByName("deleted", 0, metaObject);
    }

    /**
     * @desc: 自定义修改数据时插入数据
     * @author: chenyj
     * @date:  2020/6/13 0013
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
