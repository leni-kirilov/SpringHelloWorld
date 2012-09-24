/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.kirilov.maven.springhelloworld.methodreplacer;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Service;

/**
 * @author Leni
 */
@Service(value = "replacer")
public class FormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if (areArgumentsValid(method, args)) {
            return "die, " + args[0];
        } else {
            throw new IllegalArgumentException("Some arguments were invalid");
        }

    }

    private boolean areArgumentsValid(Method method, Object[] args) {
        if (!method.getReturnType().equals(java.lang.String.class)) {
            System.out.println("Invalid return type found. " + method.getReturnType());
            return false;
        }

        if (!"formatMessage".equals(method.getName())) {
            System.out.println("Invalid method name found. " + method.getName());
            return false;
        }

        return true;
    }
}
