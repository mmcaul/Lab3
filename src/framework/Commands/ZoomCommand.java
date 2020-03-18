package framework.Commands;

import framework.Controller.CommandController;
import framework.Model.ImageModel;

public class ZoomCommand implements Command {

    protected CommandController commandController;
    protected ImageModel image;

    public ZoomCommand(CommandController iC, ImageModel iM){
        this.commandController = iC;
        this.image = iM;
    }

    @Override
    public void handle(){

    }
}
