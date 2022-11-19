package com.learning.mybatis.mapper;

import com.learning.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 通过级联方式或用association查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpAndDeptByEid(@Param("eid") int eid);

    /**
     * 分步查询的第一步：通过分步查询查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpByStep(@Param("eid") int eid);

    /**
     * 分步查询的第二步：根据根据部门id查询员工信息
     * @param did
     * @return
     */
    List<Emp> getEmpListByDid(@Param("did") int did);

   /*
    分步查询的优点：可以实现延迟加载，但是必须在核心配置文件中设置全局配置信息：
        lazyLoadingEnabled：延迟加载的全局开关。当开启时，所有关联对象都会延迟加载
        aggressiveLazyLoading：当开启时，任何方法的调用都会加载该对象的所有属性。 否则，每个属性会按需加载
    此时就可以实现按需加载，获取的数据是什么，就只会执行相应的sql。此时可通过association和collection中的fetchType属性设置当前的分步查询是否使用延迟加载，fetchType="lazy(延迟加载)|eager(立即加载)"
    */
}
