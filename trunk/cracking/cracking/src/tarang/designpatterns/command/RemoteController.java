package tarang.designpatterns.command;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class RemoteController {

    Command slot1;
    Command slot2;
    Command undoCommand;

    public RemoteController() {
    }

    public void setSlot1(Command slot1) {
        this.slot1 = slot1;
    }

    public void setSlot2(Command slot2) {
        this.slot2 = slot2;
    }

    public void buttonWasPressed(int slotnum) {
        if(slotnum == 1) {
            slot1.execute();
            undoCommand = slot1;
        } else {
            slot2.execute();
            undoCommand = slot2;
        }
    }

    public void undoCommandPressed() {
        undoCommand.undo();
    }

}
