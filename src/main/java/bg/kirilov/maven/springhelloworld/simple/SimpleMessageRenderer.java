package bg.kirilov.maven.springhelloworld.simple;

import bg.kirilov.maven.springhelloworld.api.MessageRenderer;
import bg.kirilov.maven.springhelloworld.api.MessageProvider;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leni Kirilov
 */
@Service(value = "renderer")
public class SimpleMessageRenderer implements MessageRenderer {

    private MessageProvider provider;

    @Override
    public void render() {
        System.out.println(this.provider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }
}
