package com.silverlining.system.banking.controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class LimparCampos {
	public void limpar_txt (TextField t){
		t.setText("");
	}
	
	public void limpar_combo(ComboBox c){
		c.getSelectionModel().select(-1);
	}
}
