package view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Categoria;
import entity.Reboque;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FrmCadVeiculoController {

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

    }

    @FXML
    void btnExcluir(ActionEvent event) {

    }

    @FXML
    void btnGravar_Click(ActionEvent event) {

    }

    @FXML
    void btnVoltar_Click(ActionEvent event) {

    }

    @FXML
    void rdCaminhao_Change(ActionEvent event) {

    }

    @FXML
    void rdCarro_Change(ActionEvent event) {

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
}

