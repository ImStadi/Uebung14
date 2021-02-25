package Main;

import javafx.application.Application;
import javafx.stage.Stage;
import viewC.PhonebookC;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PhonebookC.show(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
