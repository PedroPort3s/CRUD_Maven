package view.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controle.ControlCaminhao;
import controle.ControlCarro;
import entity.Caminhao;
import entity.Carro;
import helper.Verifica;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
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
			Alert alert = new Alert(AlertType.ERROR,e.getMessage(),ButtonType.OK);
	    	alert.showAndWait();
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
			List<String> lstOpcoes = new ArrayList<String>();
			lstOpcoes.add("Editar/Excluir");
			lstOpcoes.add("Calculo gerencial de depreciação");
			lstOpcoes.add("Calculo contábli de depreciação");
			
			List<Carro> listCarro = new ControlCarro().ListarCarros();
			List<Caminhao> listCaminhao = new ControlCaminhao().ListarCaminhoes();
			
		if(listCarro != null && listCarro.size() > 0) {
				listCarro.forEach(x->lvCarros.getItems().add(x));
				
				lvCarros.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Carro>() {
				    @Override
				    public void changed(ObservableValue<? extends Carro> observable, Carro oldValue, Carro newValue) {
				    	ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>(null,lstOpcoes);
		    			choiceDialog.setTitle("Editar");
		    			choiceDialog.setHeaderText("Como deseja prosseguir?");    			
		        		choiceDialog.showAndWait().ifPresent(retorno -> {
		        			if(retorno != null) {
		        				if(retorno.contains("Editar")) 
		        				{
		        					try {
		        						Stage primaryStage = new Stage();
			        					AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/FrmCadVeiculo.fxml"));
			        					Scene scene = new Scene(root);
			        					primaryStage.setScene(scene);
			        					primaryStage.setTitle("CRUD de Veiculos");
			        					new FrmCadVeiculoController(newValue);
			        					primaryStage.show();
			        					
		    						} 
		        					catch (Exception e) {
		    							Alert alert = new Alert(AlertType.ERROR,e.getMessage(),ButtonType.OK);
		    					    	alert.showAndWait();
		    						}
		        				}
		        				else if(retorno.contains("gerencial")) 
		        				{
		        					TextInputDialog textInputDialog = new TextInputDialog("Digite o valor do carro para o calculo sobre os "+newValue.get_Categoria().getprazoDepreciacao()+ " anos.");
		        			    	textInputDialog.showAndWait().ifPresent(ret -> {
		        			    		Alert alert = new Alert(AlertType.INFORMATION,newValue.CalcularDepreciacaoGerencial(Verifica.ConverterNumeroDouble(ret)),ButtonType.OK);
			        			    	alert.showAndWait();
		        			    	});
		        				}
		        				else 
		        				{
		        					Alert alert = new Alert(AlertType.INFORMATION,newValue.CalcularDepreciacaoContabil(),ButtonType.OK);
		        			    	alert.showAndWait();
		        				}
		        				
		        				lvCaminhoes.getSelectionModel().clearSelection();
		        			}        		
		            	});
				    }
				});
		}
			
			if(listCaminhao != null && listCarro.size() > 0) {
				listCaminhao.forEach(o->lvCaminhoes.getItems().add(o));
				
				lvCaminhoes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Caminhao>() {
				    @Override
				    public void changed(ObservableValue<? extends Caminhao> observable, Caminhao oldValue, Caminhao newValue) {
				    	
				    	ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>(null,lstOpcoes);
		    			choiceDialog.setTitle("Editar");
		    			choiceDialog.setHeaderText("Como deseja prosseguir?");    			
		        		choiceDialog.showAndWait().ifPresent(retorno -> {
		        			if(retorno != null) {
		        				if(retorno.contains("Editar")) 
		        				{
		        					try {
		        						Stage primaryStage = new Stage();
			        					AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/FrmCadVeiculo.fxml"));
			        					Scene scene = new Scene(root);
			        					primaryStage.setScene(scene);
			        					primaryStage.setTitle("CRUD de Veiculos");
			        					new FrmCadVeiculoController(newValue);
			        					primaryStage.show();
			        					
		    						} 
		        					catch (Exception e) {
		    							Alert alert = new Alert(AlertType.ERROR,e.getMessage(),ButtonType.OK);
		    					    	alert.showAndWait();
		    						}
		        				}
		        				else if(retorno.contains("gerencial")) 
		        				{
		        					TextInputDialog textInputDialog = new TextInputDialog("Digite o valor do caminhão para o calculo sobre os "+newValue.get_Categoria().getprazoDepreciacao()+ " anos.");
		        			    	textInputDialog.showAndWait().ifPresent(ret -> {
		        			    		Alert alert = new Alert(AlertType.INFORMATION,newValue.CalcularDepreciacaoGerencial(Verifica.ConverterNumeroDouble(ret)),ButtonType.OK);
			        			    	alert.showAndWait();
		        			    	});
		        				}
		        				else 
		        				{
		        					Alert alert = new Alert(AlertType.INFORMATION,newValue.CalcularDepreciacaoContabil(),ButtonType.OK);
		        			    	alert.showAndWait();
		        				}
		        				
		        				lvCaminhoes.getSelectionModel().clearSelection();
		        			}        		
		            	});
				    }
				});
			}
			
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR,e.getMessage(),ButtonType.OK);
	    	alert.showAndWait();
		}
	}
}

