package com.chenyj.market;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenyj.market.entity.User;
import com.chenyj.market.mapper.IUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MarketApplicationTests {
    @Autowired
    private IUserMapper userMapper;
    @Test
    void contextLoads() {
        User user=new User();
        user.setName("热心市民陈先生");
        user.setCreateTime(new Date());
        user.setAge(25);
        userMapper.insert(user);


    }

    @Test
    void testversion() {
        User user = userMapper.selectById(1271658801208950787L);
        user.setName("七夜");
        userMapper.updateById(user);
    }

    @Test
    void page() {
        Page<User> page=new Page<>(1,2);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

//        queryWrapper.isNull().isNotNull();

//        queryWrapper.ge()
        Page<User> page1 = userMapper.selectPage(page, null);
        System.out.println(page1);
    }

    @Test
    void delete(){
        userMapper.deleteById(1271658801208950787L);
    }
}
