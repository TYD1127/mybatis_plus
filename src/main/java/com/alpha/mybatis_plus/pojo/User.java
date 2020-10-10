package com.alpha.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //    数据库主建
    @TableId(type = IdType.INPUT)
    private Long id;
    private String name;
    private Integer age;
    private String email;
//    自动填充创建时间
    private Data createTime;
//    自动填充更新时间
    private Data updateTime;
    //逻辑删除字段
    @TableLogic
    private Integer deleted;
}
