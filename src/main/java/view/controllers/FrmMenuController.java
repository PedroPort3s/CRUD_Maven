package view.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controle.ControlCaminhao;
import controle.ControlCarro;
import entity.Caminhao;
import entity.Carro;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FrmMenuController extends Application implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Carro> lvCarros;

    @FXML
    private Button btnVeiculos;

    @FXML
    private Button btnCategorias;

    @FXML
    private ListView<Caminhao> lvCaminhoes;

    @FXML
    void btnCategorias_Click(ActionEvent event) {
    	try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/FrmCadCategoria.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("CRUD de Categorias");
			primaryStage.show();
		} catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR,e.getMessage(),ButtonType.OK);
	    	alert.showAndWait();
		}
    }

    @FXML
    void btnVeiculos_Click(ActionEvent event) {
    	try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/FrmCadVeiculo.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("CRUD de Veiculos");
			primaryStage.show();
		} catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR,e.getMessage(),ButtonType.OK);
	    	alert.showAndWait();
		}
    }

    @FXML
    void initialize() {
        assert lvCarros != null : "fx:id=\"lvCarros\" was not injected: check your FXML file 'FrmMenu.fxml'.";
        assert btnVeiculos != null : "fx:id=\"btnVeiculos\" was not injected: check your FXML file 'FrmMenu.fxml'.";
        assert btnCategorias != null : "fx:id=\"btnCategorias\" was not injected: check your FXML file 'FrmMenu.fxml'.";
        assert lvCaminhoes != null : "fx:id=\"lvCaminhoes\" was not injected: check your FXML file 'FrmMenu.fxml'.";

    }
    
    @Override
	public void start(Stage primaryStage) {
		try 
		{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/FrmMenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Prova 2 Bimestre - Depreciação");
			primaryStage.show();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		this.ListarGrids();
	}
	
	private void ListarGrids() {
		try {
			List<Carro> listCarro = new ControlCarro().ListarCarros();
			List<Caminhao> listCaminhao = new ControlCaminhao().ListarCaminhoes();
			
			if(listCarro != null && listCarro.size() > 0) {
				listCarro.forEach(x->lvCarros.getItems().add(x));
			}
			
			if(listCaminhao != null && listCarro.size() > 0) {
				listCaminhao.forEach(o->lvCaminhoes.getItems().add(o));
			}
			
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR,e.getMessage(),ButtonType.OK);
	    	alert.showAndWait();
		}
	}
}

