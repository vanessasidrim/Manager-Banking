package com.silverlining.system.banking.controller;

import javafx.scene.control.Alert;

public class Alerts {
	
	public void sucesso(String tit, String msg){
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle(tit);
        dialogoInfo.setContentText(msg);
        dialogoInfo.showAndWait();
	}
	
	public void erro(String tit, String msg){
		Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
        dialogoErro.setTitle(tit);
        dialogoErro.setContentText(msg);
        dialogoErro.showAndWait();
	}
	
	public void aviso(String tit, String msg){
		Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
        dialogoAviso.setTitle(tit);
        dialogoAviso.setContentText(msg);
        dialogoAviso.showAndWait();
	}

}
