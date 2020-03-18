package framework.Commands;

import framework.Controller.CommandController;
import framework.Model.ImageModel;

public class MoveCommand implements Command {

    protected CommandController commandController;
    protected ImageModel image;

    public MoveCommand(CommandController iC, ImageModel iM){
        this.commandController = iC;
        this.image = iM;
    }

    @Override
    public void handle(){

    }
}
