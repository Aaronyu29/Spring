package ioc.dependency.injection.constructor;

import ioc.dependency.injection.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 基于 xml 资源的 构造器 注入示例
 * 声明资源和注册中心
 * @auther AaronYu
 * @date 2020/5/16 23:53
 */
public class ConstructorDependencyInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(); // 这个类可以实现层次性、集合类型、单一类型的
        // 查找。
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String resourcePath = "classpath:/META-INF/dependency-constructor-injection.xml";
        // 加载 xml 资源，解析并且生成 BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(resourcePath);
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
