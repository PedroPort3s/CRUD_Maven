package view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controle.ControlCategoria;
import entity.Categoria;
import helper.Alerts;
import helper.Verifica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FrmCadCategoriaController implements Initializable {

	@FXML
	private Button btnGravar;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTaxaDepreciacao;

	@FXML
	private TextField txtPrazoDepreciacao;

	@FXML
	private TextField txtValorResidual;
	
	private void LimparCadastro()
	{
		txtNome.clear();
		txtPrazoDepreciacao.clear();
		txtTaxaDepreciacao.clear();
		txtValorResidual.clear();
	}

	@FXML
	void btnGravar_Click(ActionEvent event) {
		try {
			Categoria cat = new Categoria(txtNome.getText(),Verifica.ConverterNumeroFloat(txtTaxaDepreciacao.getText()),Verifica.ConverterNumeroInt(txtPrazoDepreciacao.getText()),Verifica.ConverterNumeroFloat(txtValorResidual.getText()));
			ControlCategoria ctCat = new ControlCategoria();
			
			if(ctCat.GravarCategoria(cat) == 1) {
				this.LimparCadastro();
				Alert alert = Alerts.alertSucesso("Sucesso", "", "Categoria gravada com sucesso.");
				alert.showAndWait();
			}
			else {
				throw new Exception("Erro ao gravar a categoria");
			}
			
		} 
		catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR,e.getMessage() != ""?e.getMessage() : "Erro ao gravar a categoria",ButtonType.OK);
	    	alert.showAndWait();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
