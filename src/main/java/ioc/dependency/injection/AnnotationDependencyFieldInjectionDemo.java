package ioc.dependency.injection;

import container.overview.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 字段注入
 *
 * @auther AaronYu
 * @date 2020/5/18 8:23
 */
public class AnnotationDependencyFieldInjectionDemo {
    @Autowired // 忽略静态字段，默认 byType 注入
    private UserHolder userHolder;

    public static void main(String[] args) {
        // 创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类来取代我们的 xml 文件。
        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String resourceLocation = "META-INF/dependency-injection-context.xml";
        // 加载 xml 资源，解析并且生产 beanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(resourceLocation);
        applicationContext.refresh();
        // 配置类本身也是一个 Spring bean。
        AnnotationDependencyFieldInjectionDemo bean = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);
        System.out.println(bean.userHolder);

        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(Employee employee) {
        return new UserHolder(employee);
    }
}
