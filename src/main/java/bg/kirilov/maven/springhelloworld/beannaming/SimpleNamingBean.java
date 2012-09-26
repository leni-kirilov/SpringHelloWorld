package bg.kirilov.maven.springhelloworld.beannaming;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 *  Simple class to demonstrate aliases when defining Spring beans.
 *
 * @author Leni Kirilov
 */
@Service(value = "simpleBean")
public class SimpleNamingBean {

    public String getString() {
        return "blow away";
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/beannaming/app-context-anno.xml");
        context.refresh();

        SimpleNamingBean bean = (SimpleNamingBean) context.getBean("simpleBean");
        SimpleNamingBean beanAlias = (SimpleNamingBean) context.getBean("simpleAlias");

        System.out.println("bean =? beanalias = " + (bean == beanAlias));
        System.out.println(bean.getString());
        System.out.println(beanAlias.getString());
    }
}
