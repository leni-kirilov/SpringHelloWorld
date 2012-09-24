package bg.kirilov.maven.springhelloworld.methodreplacer;

import org.springframework.stereotype.Service;

/**
 * @author Leni Kirilov
 */
@Service(value = "simpleBean")
public class SimpleBean {

    public String formatMessage(String message) {
        return "hi, " + message;
    }
}
