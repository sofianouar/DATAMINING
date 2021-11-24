package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class app extends Application {

	public void start(Stage stage) {
		try {
			// Main gui
			// Main scene: pref widh = 793 pref heught = 610
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/MainScene.fxml"));
			Parent root = loader.load();
			Scene mainScene = new Scene(root);
			mainScene.getStylesheets().add(getClass().getResource("main_config.css").toExternalForm());
			stage.setScene(mainScene);
			stage.setResizable(false);
			stage.setTitle("Projet DM");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
