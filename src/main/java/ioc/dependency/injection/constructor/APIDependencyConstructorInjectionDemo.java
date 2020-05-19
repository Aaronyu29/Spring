package ioc.dependency.injection.constructor;

import ioc.dependency.injection.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 Xml 资源的依赖 setter 注入方法示例 API 配置元信息方法
 *
 * @auther AaronYu
 * @date 2020/5/18 16:21
 */
public class APIDependencyConstructorInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 生成并且注册 UserHolder 的 beanDefinition
        BeanDefinition beanDefinition = createDefinition();
        applicationContext.registerBeanDefinition("userHolder",beanDefinition);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String resourceLocation = "META-INF/dependency-injection-context.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(resourceLocation);
        // 启动应用上下文
        applicationContext.refresh();
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }

    private static BeanDefinition createDefinition() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addConstructorArgReference("boss");
//        beanDefinitionBuilder.addPropertyReference("employee","boss");
        return beanDefinitionBuilder.getBeanDefinition();
    }
}
