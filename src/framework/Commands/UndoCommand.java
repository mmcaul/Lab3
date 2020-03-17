package framework.Commands;

import framework.Commands.Command;
import framework.Controller.CommandController;

public class UndoCommand implements Command {

    protected CommandController commandController;

    public UndoCommand(CommandController iC){
        this.commandController = iC;
    }

    @Override
    public void handle(){

    }

}
