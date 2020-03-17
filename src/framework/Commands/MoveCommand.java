package framework.Commands;

import framework.Controller.CommandController;

public class MoveCommand implements Command {

    protected CommandController commandController;

    public MoveCommand(CommandController iC){
        this.commandController = iC;
    }

    @Override
    public void handle(){

    }
}
