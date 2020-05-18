package ioc.dependency.injection;

import container.overview.domain.Company;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示自动注入 ByType 的方式
 *
 * @auther AaronYu
 * @date 2020/5/18 8:36
 */
public class AutoWireByType {
    public static void main(String[] args) {
        String xmlpath = "META-INF/dependency-injection-context-byType.xml";
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(xmlpath);
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("dependency-injection-context.xml");
        lookbyType(beanFactory);
    }

    private static void lookbyType(BeanFactory beanFactory) {
        Company company = beanFactory.getBean(Company.class);
        System.out.println(company);
    }
}
