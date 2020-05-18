package container.overview.lookup;

import container.overview.domain.Employee;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @auther AaronYu
 * @date 2020/5/17 0:05
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        String xmlpath = "META-INF/dependency-injection-context.xml";
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(xmlpath);
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("dependency-injection-context.xml");
        lookbyType(beanFactory);
    }

    private static void lookbyType(BeanFactory beanFactory) {
        Employee emp = beanFactory.getBean(Employee.class);
        System.out.println(emp);
    }
}
