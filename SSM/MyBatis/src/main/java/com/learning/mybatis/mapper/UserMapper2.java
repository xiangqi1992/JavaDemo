package com.learning.mybatis.mapper;

import com.learning.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper2 {
    /*========================UserMapper1 改版 Start========================*/
    /**
     * 添加用户信息
     * @param user
     * @return
     * useGeneratedKeys：设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参数user对象的某个属性中
     */
    int insertUser(User user);

    /**
     * 删除用户信息
     */
    int deleteUser(@Param("id") int id);

    /**
     * 修改用户信息
     */
    int updateUser(User user);

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") int id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getUserList();

    /*========================UserMapper1 改版 End========================*/



    /*============================其他查询 Start===========================*/
    /**
     * 查询用户的总记录数
     * @return
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer-->int|integer
     * 例如：int-->_int|_integer
     * 例如：Map-->map,List-->list
     */
    int getCount();

    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserToMap(@Param("id") int id);

    /**
     * 查询所有用户信息为map集合
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，此
     * 时可以将这些map放在一个list集合中获取
     */
    List<Map<String, Object>> getAllUserToMapList();

    /**
     * 查询所有用户信息为map集合
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，并
     * 且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的map集合
     */
    @MapKey("ID")
    Map<String, Object> getAllUserToMap();

    /**
     * 测试模糊查询
     * @param mohu
     * @return
     */
    List<User> mohuQuery(@Param("mohu") String mohu);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 动态设置表名，查询所有的用户信息
     * @param tableName
     * @return
     */
    List<User> getAllUser(@Param("tableName") String tableName);

    /**
     * 测试模糊查询
     * @param mohu
     * @return
     */
    List<User> mohuQuery2(@Param("mohu") String mohu);
    /*===========================其他查询 End===========================*/
}
