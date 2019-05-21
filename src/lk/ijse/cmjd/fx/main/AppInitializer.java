package lk.ijse.cmjd.fx.main;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void navigateToHome(Node node, Stage mainStage) throws IOException {

        Parent root = FXMLLoader.load(AppInitializer.class.getResource("/lk/ijse/cmjd/fx/view/StartLogin.fxml"));
        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        TranslateTransition tt1 = new TranslateTransition(Duration.millis(300), root.lookup("AnchorPane"));
        tt1.setToX(0);
        tt1.setFromX(-mainScene.getWidth());
        tt1.play();

        mainStage.centerOnScreen();
    }

    /**
     * @param x the command line arguments
     */
    public static void main(String[] x) {
        launch(x);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/StartLogin.fxml"));//StartLogin   MainForm

        Scene mainScene = new Scene(root);

        primaryStage.setTitle("Reliance Hotel Management System" );
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);

        primaryStage.show();

    }

}
