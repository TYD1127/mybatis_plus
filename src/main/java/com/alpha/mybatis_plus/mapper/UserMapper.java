package com.alpha.mybatis_plus.mapper;

import com.alpha.mybatis_plus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
//dao层

@Repository
public interface UserMapper extends BaseMapper<User> {

}
