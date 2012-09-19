package bg.kirilov.maven.springhelloworld.api;

/**
 *
 * @author Leni
 */
public interface MessageRenderer {

    public void setMessageProvider(MessageProvider messageProvider);

    public void render();
}
