package lk.ijse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Application1 extends Application {
    public static void main(String[] args) {
            launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage secondaryStage = new Stage();
        Parent stage2 = FXMLLoader.load(getClass().getResource("/server.fxml"));

        secondaryStage.setScene(new Scene(stage2));
        secondaryStage.initStyle(StageStyle.DECORATED);
        secondaryStage.show();

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/client.fxml"))));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }
}
