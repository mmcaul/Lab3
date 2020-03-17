package framework;

public class UndoCommand implements Command {

    protected CommandController commandController;

    public UndoCommand(CommandController iC){
        this.commandController = iC;
    }

    public void handle(){

    }

}
