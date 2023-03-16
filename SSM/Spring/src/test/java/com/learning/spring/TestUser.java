package com.learning.spring;

import com.learning.spring.config.SpringConfig;
import com.learning.spring.pojo.User;
import com.learning.spring.pojo.UserAnnotation;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 一、获取Bean：context.getBean("user")
 * 二、依赖注入：
 *    2.1 注入的两种方式：
 *      setter注入
 *      构造器注入
 *    2.2 特殊值的注入：
 *      字面量
 *      null
 *      xml实体
 *      CDATA节
 *    2.3 数据类型注入：
 *      对象
 *      数组
 *      集合（list/map）
 *    2.4 p p/c
 *    2.5 引用外部属性文件 context
 *    2.6 作用域 scope
 *
 * 三、Bean生命周期：
 *     1、Spring容器，从XML文件中读取Bean的定义，并实例化Bean(调用无参构造);
 *     2、根据Bean的定义，给bean对象设置相关属性;
 *     3、如果Bean实现了BeanNameAware接口，Spring传递bean的ID到setBeanName(String name)方法;
 *     4、如果Bean实现了BeanFactoryAware接口，Spring传递beanFactory给setBeanFactory(BeanFactory beanFactory)方法;
 *     5、如果有任何与bean相关联的BeanPostProcessor，Spring会在postProcessBeforeInitialization(Object bean, String beanName)后置处理器方法内调用它们;
 *     6、如果bean实现InitializingBean了，调用它的afterPropertySet()方法，如果bean声明了初始化方法，调用此初始化方法;
 *     7、如果有BeanPostProcessor与bean关联，这些bean的postProcessAfterInitialization(Object bean, String beanName)后置处理器方法将被调用;
 *     ===== bean对象创建完成，可以使用了 =====
 *     8、如果bean实现DisposableBean，它将调用destroy()方法。
 *     ===== IOC容器关闭了 =====
 * 四、FactoryBean 整合第三方时使用
 * 五、自动装配 autowire byType、byName，简化bean获取方式，只用声明属性。
 *
 * 六、基于注解管理Bean
 *      1、开启组件扫描
 *      2、bean上加上注解：
 *          @Component
 *          @Repository dao层
 *          @Service service层
 *          @Controller controller层
 *      3、注入：
 *          @Autowired注入：默认是byType；配合@Qualifier(value="user") byName
 *          @Resource注入：默认是byName，如果找不到，自动byType。
 */
public class TestUser {

    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserXml(){
        // 1、加载bean.xml配置文件
        // 2、对xml文件进行解析操作
        // 3、获取xml文件bean标签属性值（id属性值和class属性值）
        // 4、将Bean定义信息对象放入到 Map<String,BeanDefinition> beanDefinitionMap 集合中
        // 5、使用BeanFactory工厂+反射 根据类全路径创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取创建的对象
        // 1、根据id获取Bean
        User user = (User) context.getBean("user");
        System.out.println("一、根据id获取Bean: " + user);
        // 2、根据类型获取Bean
        // 注：当根据类型获取bean时，要求IOC容器中指定类型的bean有且只有一个。（expected single matching bean but found2: user,user1）
        User user2 = context.getBean(User.class);
        System.out.println("二、根据类型获取Bean: " + user2);
        // 3、根据id和类型获取Bean
        User user3 = context.getBean("user", User.class);
        System.out.println("三、根据id和类型获取Bean: " + user3);

        // 使用对象调用方法进行测试
        user.add();

        // 手动调用成功了
        System.out.println("6、 执行调用成功。。。");

        ((ClassPathXmlApplicationContext) context).close();//销毁
    }

    @Test
    public void testUserAnnotation(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserAnnotation user = context.getBean(UserAnnotation.class);
        System.out.println(user);
    }
}
