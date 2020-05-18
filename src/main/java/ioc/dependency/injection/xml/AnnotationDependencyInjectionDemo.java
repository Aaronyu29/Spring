package ioc.dependency.injection.xml;

import container.overview.domain.Employee;
import ioc.dependency.injection.UserHolder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于注解方式的 依赖 xml 资源来进行 setter 方法注入
 *
 * @auther AaronYu
 * @date 2020/5/18 8:23
 */
public class AnnotationDependencyInjectionDemo {
    public static void main(String[] args) {
        // 创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类来取代我们的 xml 文件。
        applicationContext.register(AnnotationDependencyInjectionDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String resourceLocation = "META-INF/dependency-injection-context.xml";
        // 加载 xml 资源，解析并且生产 beanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(resourceLocation);
        applicationContext.refresh();
        UserHolder holder = applicationContext.getBean(UserHolder.class);
        System.out.println(holder);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(Employee employee) {
        return new UserHolder(employee);
    }
}
