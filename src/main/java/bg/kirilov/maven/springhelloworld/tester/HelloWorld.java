package bg.kirilov.maven.springhelloworld.tester;

import bg.kirilov.maven.springhelloworld.simple.SimpleMessageProvider;
import bg.kirilov.maven.springhelloworld.api.MessageProvider;
import bg.kirilov.maven.springhelloworld.api.MessageRenderer;
import bg.kirilov.maven.springhelloworld.simple.SimpleMessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class HelloWorld {

    public static final String RENDERER = "renderer";
    public static final String PROVIDER = "provider";

    public static void main(String[] args) {
        main_SetterInj(args);
//        main_annotations(args);
//        main_withXML(args);
//        main_StraightForward(args);
    }

    public static void main_SetterInj(String[] args) {

        String xmlConfigLocation = "META-INF/spring/app-context-setter-inj-xml.xml";
        String annotationConfigLocation = "META-INF/spring/app-context-setter-inj-annotation.xml";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        context.load(xmlConfigLocation);
        context.load(annotationConfigLocation);
        context.refresh();

//        MessageProvider provider = context.getBean(PROVIDER, MessageProvider.class);
//        System.out.println(provider.getMessage());

        MessageRenderer renderer = context.getBean(RENDERER, MessageRenderer.class);
        renderer.render();
    }

    /**
     * Usage of more flexible GenericXmlApplicationContext with both xml declarative and annotation's based DI for
     * Spring
     *
     * @param args
     */
    public static void main_annotations(String[] args) {
        //both ways are valid
        String annotationConfigLocation = "META-INF/spring/app-context-annotation.xml";
        String xmlDeclarativeConfigLocation = "META-INF/spring/app-context.xml";

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        for lazy configuration
        context.load(xmlDeclarativeConfigLocation);
        context.refresh();

        MessageProvider provider = context.getBean("provider", MessageProvider.class);
        System.out.println(provider.getMessage());

        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }

    /**
     * Good-for-nothing approach with ClassPathApplicationContext.
     *
     * @deprecated in favour of GenericApplicationContext and GenericXmlAnnotationContext
     * @param args
     */
    @Deprecated
    public static void main_withXML(String[] args) {
        String configLocation = "META-INF/spring/app-context-annotation.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();

        System.exit(0);
    }

    /**
     * This is not Dependency Injection at all.. not the Spring way :)
     *
     * @param args
     * @deprecated
     */
    @Deprecated
    public static void main_StraightForward(String[] args) {
        MessageProvider msgProvider = new SimpleMessageProvider();
        MessageRenderer msgRenderer = new SimpleMessageRenderer();

        msgRenderer.setMessageProvider(msgProvider);
        msgRenderer.render();
    }
}
