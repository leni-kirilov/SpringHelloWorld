package bg.kirilov.maven.springhelloworld.prototype;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * Simple class to demonstrate how to test/create prototype lifecycle beans with Spring
 *
 * @author Leni Kirilov
 */
@Service(value = "simplePrototypeBean")
public class SimpleNamingBean {

    public String getString() {
        return "blow away";
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/prototype/app-context-anno.xml");
        context.refresh();

        SimpleNamingBean bean1 = (SimpleNamingBean) context.getBean("simplePrototypeBean");
        SimpleNamingBean bean2 = (SimpleNamingBean) context.getBean("simplePrototypeBean");

        System.out.println("bean =? bean2 = " + (bean1 == bean2));
        System.out.println(bean1.getString());
        System.out.println(bean2.getString());
    }
}
