package bg.kirilov.maven.springhelloworld.constructorinj;

import bg.kirilov.maven.springhelloworld.api.MessageProvider;
import bg.kirilov.maven.springhelloworld.api.MessageRenderer;
import bg.kirilov.maven.springhelloworld.tester.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leni Kirilov
 */
@Service(value = HelloWorld.RENDERER)
public class ConstructorInjMessageRenderer implements MessageRenderer {

    MessageProvider provider;

    //here it automatically manages to find a bean that is for this interface and put it here
    @Autowired
    public ConstructorInjMessageRenderer(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void render() {
        System.out.println("Renderer: " + this.provider.getMessage());
    }
}
