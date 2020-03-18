package framework.Commands;

import framework.Commands.Command;
import framework.Controller.CommandController;
import framework.Model.ImageModel;

public class UndoCommand implements Command {

    protected CommandController commandController;
    protected ImageModel image;

    public UndoCommand(CommandController iC, ImageModel iM){
        this.commandController = iC;
        this.image = iM;
    }

    @Override
    public void handle(){

    }

}
