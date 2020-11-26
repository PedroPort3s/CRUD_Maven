package view.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controle.ControlCaminhao;
import controle.ControlCarro;
import controle.ControlCategoria;
import controle.ControlReboque;
import entity.Caminhao;
import entity.Carro;
import entity.Categoria;
import entity.Reboque;
import helper.Alerts;
import helper.Verifica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FrmCadVeiculoController implements Initializable {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private RadioButton rdCarro;

	@FXML
	private RadioButton rdCaminhao;

	@FXML
	private ComboBox<Reboque> cbReboque;

	@FXML
	private ComboBox<Categoria> cbCategorias;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCor;

	@FXML
	private TextField txtQuilometragem;

	@FXML
	private TextField txtValor;

	@FXML
	private TextField txtNumPortas;

	@FXML
	private TextField txtNumEixos;

	@FXML
	private Button btnCadReboque;

	@FXML
	private Button btnGravar;

	@FXML
	private Label lbIdValor;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnVoltar;

	@FXML
	private TextField txtQtdRodas;

	@FXML
	void btnCadReboque_Click(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FrmCadReboque.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("CRUD de Veiculos");
			primaryStage.show();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}
	}

	@FXML
	void btnExcluir(ActionEvent event) {
		try {
			int id = Verifica.ConverterNumeroInt(lbIdValor.getText());

			if (id > 0) {
				ControlCaminhao ctCaminhao = new ControlCaminhao();

				Caminhao caminhao = ctCaminhao.CarregarCaminhao(id);

				if (caminhao == null) {
					ControlCarro ctCarro = new ControlCarro();
					Carro carro = ctCarro.CarregarCarro(id);

					if (carro != null) {
						if (ctCarro.ExcluirCarro(carro) != 1) {
							throw new Exception("Erro ao excluir carro");
						} else {
							Alert alert = Alerts.alertSucesso("Sucesso", "", "Carro excluido com sucesso.");
							alert.showAndWait();
						}
					} else {
						throw new Exception("N�o foi encontrado nenhum carro ou caminhao com o id" + id);
					}
				} else {
					if (ctCaminhao.ExcluirCaminhao(caminhao) != 1) {
						throw new Exception("Erro ao excluir o caminhao");
					} else {
						Alert alert = Alerts.alertSucesso("Sucesso", "", "Caminhao excluido com sucesso.");
						alert.showAndWait();
					}
				}
			} else {
				throw new Exception("N�o h� nenhum veiculo carregado");
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}
	}

	@FXML
	void btnGravar_Click(ActionEvent event) {
		try {
			if (rdCaminhao.isSelected()) {
				Caminhao caminhao = new Caminhao();
				
				caminhao.set_Categoria(cbCategorias.getSelectionModel().getSelectedItem());
				caminhao.set_cor(txtCor.getText());
				caminhao.set_nome(txtNome.getText());
				caminhao.set_qtdRodas(Verifica.ConverterNumeroInt(txtQtdRodas.getText()));
				caminhao.set_valor(Verifica.ConverterNumeroDouble(txtValor.getText()));
				caminhao.setQuilometragem(Verifica.ConverterNumeroDouble(txtQuilometragem.getText()));
				caminhao.set_qtdEixos(Verifica.ConverterNumeroInt(txtNumEixos.getText()));
				caminhao.setReboque(cbReboque.getSelectionModel().getSelectedItem());

				if (new ControlCaminhao().GravarCaminhao(caminhao) != 1) {
					throw new Exception("N�o foi possivel gravar um caminhao.");
				} 
				else {
					Alert alert = Alerts.alertSucesso("Sucesso", "", "Caminhao gravado com sucesso.");
					alert.showAndWait();
					LimparCadastro();
				}
			} else {
				Carro carro = new Carro();

				carro.set_Categoria(cbCategorias.getSelectionModel().getSelectedItem());
				carro.set_cor(txtCor.getText());
				carro.set_nome(txtNome.getText());
				carro.set_qtdRodas(Verifica.ConverterNumeroInt(txtQtdRodas.getText()));
				carro.set_valor(Verifica.ConverterNumeroDouble(txtValor.getText()));
				carro.setQuilometragem(Verifica.ConverterNumeroDouble(txtQuilometragem.getText()));
				carro.set_qtdPortas(Verifica.ConverterNumeroInt(txtNumPortas.getText()));

				if (new ControlCarro().GravarCarro(carro) != 1) {
					throw new Exception("N�o foi possivel gravar um carro.");
				} 
				else {
					Alert alert = Alerts.alertSucesso("Sucesso", "", "Carro gravado com sucesso.");
					alert.showAndWait();
					LimparCadastro();
				}
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}
	}

	@FXML
	void btnVoltar_Click(ActionEvent event) {
		try {
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

	@FXML
	void rdCaminhao_Change(ActionEvent event) {
		this.TravaCaminhao(false);
		this.TravaCarro(true);
	}

	@FXML
	void rdCarro_Change(ActionEvent event) {
		this.TravaCaminhao(true);
		this.TravaCarro(false);
	}

	private void TravaCarro(boolean trava) {
		txtNumPortas.setDisable(trava);
	}

	private void TravaCaminhao(boolean trava) {
		cbReboque.setDisable(trava);
		txtNumEixos.setDisable(trava);
		btnCadReboque.setDisable(trava);
	}

	@FXML
	void initialize() {
		assert rdCarro != null : "fx:id=\"rdCarro\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert rdCaminhao != null : "fx:id=\"rdCaminhao\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert cbReboque != null : "fx:id=\"cbReboque\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert cbCategorias != null : "fx:id=\"cbCategorias\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert txtCor != null : "fx:id=\"txtCor\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert txtQuilometragem != null : "fx:id=\"txtQuilometragem\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert txtValor != null : "fx:id=\"txtValor\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert txtNumPortas != null : "fx:id=\"txtNumPortas\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert txtNumEixos != null : "fx:id=\"txtNumEixos\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert btnCadReboque != null : "fx:id=\"btnCadReboque\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert btnGravar != null : "fx:id=\"btnGravar\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert lbIdValor != null : "fx:id=\"lbIdValor\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert btnExcluir != null : "fx:id=\"btnExcluir\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";
		assert txtQtdRodas != null : "fx:id=\"txtQtdRodas\" was not injected: check your FXML file 'FrmCadVeiculo.fxml'.";

	}
	
	private void LimparCadastro() {
		txtCor.clear();
		txtNome.clear();
		txtNumEixos.clear();
		txtNumPortas.clear();
		txtQtdRodas.clear();
		txtQuilometragem.clear();
		txtValor.clear();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			
			if(rdCaminhao.isSelected()) {
				this.TravaCaminhao(false);
				this.TravaCarro(true);
			}
			else {
				this.TravaCaminhao(true);
				this.TravaCarro(false);
			}
			
			List<Categoria> lstCategorias = new ControlCategoria().ListarCategorias();

			if (lstCategorias != null && lstCategorias.size() > 0) {
				ObservableList<Categoria> categorias = FXCollections.observableArrayList(lstCategorias);
				cbCategorias.setItems(categorias);
			}

			List<Reboque> lstReboques = new ControlReboque().ListarReboques();

			if (lstReboques != null && lstReboques.size() > 0) {
				ObservableList<Reboque> reboques = FXCollections.observableArrayList(lstReboques);
				cbReboque.setItems(reboques);
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}

	}
}
