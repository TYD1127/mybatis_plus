package com.alpha.mybatis_plus;

import com.alpha.mybatis_plus.mapper.UserMapper;
import com.alpha.mybatis_plus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    //查询？
    @Test
    void contextLoads() {

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        System.out.println("你好");

    }

    //插入
    @Test
    public void insert() {
        User user = new User();
        user.setName("tangya");
        user.setId(8L);
        user.setAge(18);
        user.setEmail("2677243889@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    //更新
    @Test
    public void update() {
        User user = new User();
        user.setId(8L);
        user.setName("tangyd");
        user.setAge(45);
        user.setEmail("484776775@qq.com");
        int insert = userMapper.updateById(user);
        System.out.println(insert);
        System.out.println(user);
    }

    //查询
    @Test
    public void cx() {
//        User user = userMapper.selectById(8L);
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 4));
        users.forEach(System.out::println);
        System.out.println(users);
        System.out.println("你好");

    }    //条件查询

    @Test
    public void tjcx() {
        HashMap<String, Object> m = new HashMap<>();
        m.put("age", "18");
        m.put("name", "Jone");
        List<User> users = userMapper.selectByMap(m);
        System.out.println("你好");
        users.forEach(System.out::println);

    }

    //
    // 分页查询
    @Test
    public void fycx() {
        //当前页
        Page<User> page = new Page<>(1, 3);
        Page<User> page1 = new Page<>(3, 5);
        userMapper.selectPage(page, null);
        userMapper.selectPage(page1, null);
        page.getRecords().forEach(System.out::println);
        System.out.println("你好");
        page1.getRecords().forEach(System.out::println);
    }

    //删除
    @Test
    public void niasa() {
        userMapper.deleteById(5L);
    }

    //通过map删除
    @Test
    public void testDeleteMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        userMapper.deleteByMap(map);
    }

    @Test
    public void wapp() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .ge("age",18);

        userMapper.selectList(wrapper).forEach(System.out::println);
    }

}
