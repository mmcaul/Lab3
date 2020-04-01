package framework.model;

import framework.MonObservable;

import java.io.IOException;

public class Model extends MonObservable {

    protected Model() throws IOException {
        PerspectiveModel prespective = new PerspectiveModel();
        ImageModel image = new ImageModel();
    }
}
