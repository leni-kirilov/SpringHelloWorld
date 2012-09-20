package bg.kirilov.maven.springhelloworld.simple;

import bg.kirilov.maven.springhelloworld.api.MessageProvider;
import bg.kirilov.maven.springhelloworld.tester.HelloWorld;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leni Kirilov
 */
@Service(value = HelloWorld.PROVIDER)
public class SimpleMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello, World!";
    }
}