package mvc.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Taken from https://stackoverflow.com/questions/36868391/using-javafx-controller-without-fxml/36873768#36873768
 * 
 * also helpful:
 * https://softwareengineering.stackexchange.com/questions/97880/in-mvc-should-a-model-handle-validation
 * 
 * @author bilodeau
 *
 */
public class MVCExampleMain extends Application {

	@Override
    public void start(Stage primaryStage) {
        AdditionModel model = new AdditionModel();
        AdditionController controller = new AdditionController(model);
        AdditionView view = new AdditionView(controller, model);

        Scene scene = new Scene(view.asParent(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
