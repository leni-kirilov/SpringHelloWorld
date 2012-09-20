/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.kirilov.maven.springhelloworld.constructorinj;

import bg.kirilov.maven.springhelloworld.api.MessageProvider;
import bg.kirilov.maven.springhelloworld.tester.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leni Kirilov
 */
@Service(value = HelloWorld.PROVIDER)
public class ConstructorInjMessageProvider implements MessageProvider {

    String message;

    @Autowired
    public ConstructorInjMessageProvider(@Value(value = "Constructor injection in annotation") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
