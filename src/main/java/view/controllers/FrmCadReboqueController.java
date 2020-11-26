package view.controllers;

import controle.ControlCategoria;
import controle.ControlReboque;
import entity.Categoria;
import entity.Reboque;
import helper.Verifica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FrmCadReboqueController {

    @FXML
    private Button btnGravar;

    @FXML
    private TextField txtNomeReboque;

    @FXML
    private TextField txtValorReboque;

    @FXML
    private TextField txtQuilometragemReboque;

    @FXML
    void btnGravar_Click(ActionEvent event) {
    	try {
			Reboque reb = new Reboque();
			reb.setNomeReboque(txtNomeReboque.getText());
			reb.setQuilometragem(Verifica.ConverterNumeroDouble(txtQuilometragemReboque.getText()));
			reb.setValorReboque(Verifica.ConverterNumeroDouble(txtValorReboque.getText()));
			
			if(new ControlReboque().GravarReboque(reb) == 1) {
				this.LimparCadastro();
			}
			else {
				throw new Exception("Erro ao gravar a reboque");
			}
			
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR,e.getMessage() != ""?e.getMessage() : "Erro ao gravar a reboque",ButtonType.OK);
	    	alert.showAndWait();
		}
    }
    
    private void LimparCadastro() {
    	txtNomeReboque.clear();
    	txtQuilometragemReboque.clear();
    	txtValorReboque.clear();
    }

}
