package bg.kirilov.maven.springhelloworld.methodreplacer;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Simple example of Method Replacement technique with 1 Spring XML descriptor<br/> The usage of "cglib" library is
 * needed here as a dependency.
 *
 *
 * @author Leni
 */
public class Tester {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/app-context-method-replacer.xml");
        context.refresh();

        SimpleBean replacedBean = context.getBean("replacedBean", SimpleBean.class);
        SimpleBean standardBean = context.getBean("simpleBean", SimpleBean.class);

        String result = replacedBean.formatMessage("Leni");
        System.out.println(result);
        String result2 = standardBean.formatMessage("Leni");
        System.out.println(result2);
    }
}
