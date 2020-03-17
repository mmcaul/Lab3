package framework.Commands;

import framework.Controller.CommandController;

public class ZoomCommand implements Command {

    protected CommandController commandController;

    public ZoomCommand(CommandController iC){
        this.commandController = iC;
    }

    @Override
    public void handle(){

    }
}
