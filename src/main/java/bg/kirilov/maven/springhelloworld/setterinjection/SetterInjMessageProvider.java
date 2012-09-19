package bg.kirilov.maven.springhelloworld.setterinjection;

import bg.kirilov.maven.springhelloworld.api.MessageProvider;
import bg.kirilov.maven.springhelloworld.tester.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leni
 */
@Service(value = HelloWorld.PROVIDER)
public class SetterInjMessageProvider implements MessageProvider {

    private String message;

    @Override
    public String getMessage() {
        return this.message;
    }

    @Autowired
    public void setMessage(@Value(value = "annotation setter inj") String message) {
        this.message = message;
    }
}
