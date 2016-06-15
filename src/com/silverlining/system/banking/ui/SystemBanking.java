package com.silverlining.system.banking.ui;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SystemBanking extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/com/silverlining/system/banking/controller/FXMLDocument.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
		
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/silverlining/system/banking/controller/icon.png")));
		stage.setTitle("System Banking");
	}
	
	public static void main(String[] args) {
		
		File file = new File("C:/SystemBanking");
		if(!file.isDirectory())
			file.mkdir();
		
		launch(args);
	}

}
