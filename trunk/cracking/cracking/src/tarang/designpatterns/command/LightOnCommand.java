package tarang.designpatterns.command;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class LightOnCommand extends Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
