# MybatisPlusDemo:一天了解MybatisPlus
### 1、MybatisPlus简介
  简化Mybatis开发，只做增强。

### 2、版本说明（见POM文件）
    IDE：IDEA
    Jdk：1.8+
    构建工具：Maven 3.6.3+
    MySQL版本：MySQL 8.0+
    MyBatis版本：MyBatis 3.5.10+

### 3、主要文件（入门）
+ 核心配置文件 [mybatis-config.xml](src/main/resources/mybatis-config.xml):
    主要用于配置连接数据库的环境以及MyBatis的全局配置信息。
+ mapper接口 [UserMapper1.java](src/main/java/com/learning/mybatisplus/mapper/UserMapper1.java)
+ MyBatis的映射文件 [UserMapper1.xml](src/main/resources/mappers/UserMapper1.xml)

### 4、测试（入门）
&emsp; 略，见[MyBatisTest.java](src/test/java/com/learning/mybatis/test/UserTest.java)


>  总结：以上demo存在几个问题：
> 1、查询参数写死在xml里面，很傻很没用；
> 2、只能返回对应的model，扩展的model怎么办；
> 3、以上全是单表操作，如果是多表操作怎么做。
> 4、…


### 5、MyBatis获取参数值的两种方式（基础）
    MyBatis获取参数值的两种方式：${}和#{}
        ${}的本质就是字符串拼接；
        #{}的本质就是占位符赋值。
### 6、MyBatis的各种查询功能（基础）
&emsp; 略，见
[UserMapper2.java](src/main/java/com/learning/mybatisplus/mapper/UserMapper2.java)
和
[UserMapper2.xml](src/main/resources/mappers/UserMapper2.xml)
### 7、特殊SQL的执行（基础）
&emsp; 略，见
[UserMapper2.java](src/main/java/com/learning/mybatisplus/mapper/UserMapper2.java)
和
[UserMapper2.xml](src/main/resources/mappers/UserMapper2.xml)
### 8、自定义映射resultMap（基础）
&emsp; 略，见
[EmpMapper.java](src/main/java/com/learning/mybatisplus/mapper/EmpMapper.java)、
[EmpMapper.xml](src/main/resources/mappers/EmpMapper.xml)
和
[DeptMapper.java](src/main/java/com/learning/mybatisplus/mapper/DeptMapper.java)、
[DeptMapper.xml](src/main/resources/mappers/DeptMapper.xml)


>  总结：以上内容虽然能帮助我们使用mybatis，但存在几个问题：
> 1、sql参数固定，无法根据参数值的不同做出不同处理；
> 2、开发流程长，效率不高：写sql建表语句 -》 执行sql语句 -》 (核心配置文件) -》 Mapper接口 -》 Mapper映射文件 -》 Model -》…
> 3、分页麻烦，而前端往往是分页展示列表。
> 4、…


### 9、动态SQL（重点）
+ if
+ where
+ trim
+ choose when otherwise
+ foreach
+ sql片段

&emsp; 略，见
[EmpMapper4Tag.java](src/main/java/com/learning/mybatisplus/mapper/EmpMapper4Tag.java)
和
[EmpMapper4Tag.xml](src/main/resources/mappers/EmpMapper4Tag.xml)

### 10、MyBatis的缓存(重点,工作未使用)
#### 10.1、MyBatis的一级缓存
    SqlSession级别，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问。
    使一级缓存失效的四种情况：
       1) 不同的SqlSession对应不同的一级缓存
       2) 同一个SqlSession但是查询条件不同
       3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
       4) 同一个SqlSession两次查询期间手动清空了缓存
#### 10.2、MyBatis的二级缓存
    SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取。
    二级缓存开启的条件：
       a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
       b>在映射文件中设置标签<cache />
       c>二级缓存必须在SqlSession关闭或提交之后有效
       d>查询的数据所转换的实体类类型必须实现序列化的接口
    使二级缓存失效的情况：
        两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效。

#### 10.3、二级缓存的相关配置
    在mapper配置文件中添加的cache标签可以设置一些属性：
        eviction属性：缓存回收策略，默认的是 LRU。
            LRU（Least Recently Used） – 最近最少使用的：移除最长时间不被使用的对象。
            FIFO（First in First out） – 先进先出：按对象进入缓存的顺序来移除它们。
            SOFT – 软引用：移除基于垃圾回收器状态和软引用规则的对象。
            WEAK – 弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象。
        flushInterval属性：刷新间隔，单位毫秒默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新
        size属性：引用数目，正整数代表缓存最多可以存储多少个对象，太大容易导致内存溢出
        readOnly属性：只读，true/false
            true：只读缓存；会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改。这提供了很重要的性能优势。
            false：读写缓存；会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是false。
#### 10.4、MyBatis缓存查询的顺序
    先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用。
    如果二级缓存没有命中，再查询一级缓存
    如果一级缓存也没有命中，则查询数据库
    SqlSession关闭之后，一级缓存中的数据会写入二级缓存
#### 10.5、整合第三方缓存EHCache
&emsp; 略。

### 11、MyBatis的逆向工程(重点)
    逆向工程：先创建数据库表，由框架负责根据数据库表，反向生成如下资源：
        1、Java实体类
        2、Mapper接口
        3、Mapper映射文件
    略，方式有很多，比如：1、添加插件；2、启动一个客户端生成。
### 12、分页插件(重点)
#### 1、添加依赖
```xml
    <!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper -->
    <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper</artifactId>
        <version>5.2.0</version>
    </dependency> 
```
#### 2、（在核心配置文件中）配置分页插件
```xml
    <plugins>
        <!--设置分页插件-->
        <plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
    </plugins>
```
#### 3、分页插件使用
&emsp; 略，见[MyBatisTest.java](src/test/java/com/learning/mybatis/test/UserTest.java)。

    常用数据：
        pageNum：当前页的页码
        pageSize：每页显示的条数
        size：当前页显示的真实条数
        total：总记录数
        pages：总页数
        prePage：上一页的页码
        nextPage：下一页的页码
        isFirstPage/isLastPage：是否为第一页/最后一页
        hasPreviousPage/hasNextPage：是否存在上一页/下一页
        navigatePages：导航分页的页码数
        navigatepageNums：导航分页的页码，[1,2,3,4,5]