package presentation.scenes;

import javafx.scene.layout.Pane;

public abstract class ViewController {
     
	protected Pane rootView;

    public ViewController() {

    }

    public abstract void init();

    public Pane getRootView() {
        return rootView;
    }
}