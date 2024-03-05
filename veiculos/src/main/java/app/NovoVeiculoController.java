
package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import modelo.Veiculo;
import util.Dao;

public class NovoVeiculoController {
    @FXML
    private TextField campoCodigo; 
    
    @FXML
    private TextField campoMarca; 
    
    @FXML
    private TextField campoModelo; 
    
    @FXML
    private TextField campoPlaca;
    
    @FXML
    private void cadastrarVeiculo(){
        Veiculo veiculo = new Veiculo();
        //veiculo.setCodigo(Integer.valueOf(campoCodigo.getText()));
        veiculo.setMarca(campoMarca.getText());
        veiculo.setModelo(campoModelo.getText());
        veiculo.setPlaca(campoPlaca.getText());
        Dao<Veiculo> dao = new Dao(Veiculo.class); 
        dao.inserir(veiculo);
        limparCampos();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Veiculo cadastrado");
        alert.show();
    }
    
    @FXML
    private void limparCampos(){
        campoCodigo.setText("");
        campoMarca.setText("");
        campoModelo.setText("");
        campoPlaca.setText("");
    }
      
    @FXML
    private void voltarAoMenu() throws IOException{
        App.setRoot("menu");
    }
    
}
