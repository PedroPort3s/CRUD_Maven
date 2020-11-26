package view.controllers;

import controle.ControlReboque;
import entity.Reboque;
import helper.Alerts;
import helper.Verifica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	private Button btnVoltar;

	@FXML
	void btnGravar_Click(ActionEvent event) {
		try {
			Reboque reb = new Reboque();
			reb.setNomeReboque(txtNomeReboque.getText());
			reb.setQuilometragem(Verifica.ConverterNumeroDouble(txtQuilometragemReboque.getText()));
			reb.setValorReboque(Verifica.ConverterNumeroDouble(txtValorReboque.getText()));

			if (new ControlReboque().GravarReboque(reb) == 1) {
				this.LimparCadastro();
				Alert alert = Alerts.alertSucesso("Sucesso", "", "Reboque gravado com sucesso.");
				alert.showAndWait();
			} else {
				throw new Exception("Erro ao gravar a reboque");
			}

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage() != "" ? e.getMessage() : "Erro ao gravar a reboque",
					ButtonType.OK);
			alert.showAndWait();
		}
	}

	private void LimparCadastro() {
		txtNomeReboque.clear();
		txtQuilometragemReboque.clear();
		txtValorReboque.clear();
	}

	@FXML
	void btnVoltar_Click(ActionEvent event) {
		try {
			Stage stage = (Stage) btnVoltar.getScene().getWindow();
			stage.close();

			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FrmMenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("CRUD de Veiculos");
			primaryStage.show();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}
	}

}
