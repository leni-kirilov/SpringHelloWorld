package bg.kirilov.maven.springhelloworld.setterinjection;

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
public class SetterInjMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        System.out.println(this.messageProvider.getMessage());
    }
}
