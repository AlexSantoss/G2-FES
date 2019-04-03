import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Core extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("ui/UI.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("cliente/Cliente.fxml"));
>>>>>>> e5d395e1e6dfcb69a27e562d78753b222ea1ae12
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
