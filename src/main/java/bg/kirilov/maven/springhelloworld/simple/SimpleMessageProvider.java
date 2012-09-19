package bg.kirilov.maven.springhelloworld.simple;

import bg.kirilov.maven.springhelloworld.api.MessageProvider;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leni Kirilov
 */
@Service(value = "provider")
public class SimpleMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello, World!";
    }
}