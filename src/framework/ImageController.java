package framework;

public class ImageController {

    // Singleton
    private static ImageController instance = new ImageController();
    private ImageController(){};
    public static ImageController getInstance(){
        return instance;
    }


}
