package com.learning.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

// @Data = @Setter + @Getter + @EqualsAndHashCode + @ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user") // @TableName 优先于 全局配置
public class User {

    /**
     * 用户id
     */
    @TableId(type= IdType.ASSIGN_ID) // 1、指定主键，默认主键时id属性,2、value值为列名，默认同属性名,3、type值为主键策略：IdType.ASSIGN_ID（默认雪花算法）、IdType.AUTO
    private Long id;

    /**
     * 姓名
     *
     * @TableField
     * 情况一：若实体类中的属性使用的是驼峰命名风格，而表中的字段使用的是下划线命名风格
     *  例如实体类属性userName，表中字段user_name
     *  此时MyBatis-Plus会自动将下划线命名风格转化为驼峰命名风格
     * 情况二：若实体类中的属性和表中的字段不满足情况一
     *  例如实体类属性name，表中字段username
     *  此时需要在实体类属性上使用@TableField("username")设置属性所对应的字段名
     */
    // @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 删除标识
     */
    @TableLogic(delval = "Y",value = "N") //逻辑删除字段,默认是0/1,设置N/Y。没有该注解是物理删除。TODO 如果逻辑删除和物理删除需要同事存在，改如何处理？
    private String deleted;
}
