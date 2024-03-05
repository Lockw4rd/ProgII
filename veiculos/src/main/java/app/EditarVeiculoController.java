
package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import modelo.Veiculo;
import util.Dao;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class EditarVeiculoController {
    
    @FXML
    private ComboBox<Veiculo> comboVeiculos;
    private ObservableList<Veiculo> listaOb;
    private List<Veiculo> lista;
    private Dao<Veiculo> dao;
    
    @FXML
    private TextField campoCodigo; 
    
    @FXML
    private TextField campoMarca; 
    
    @FXML
    private TextField campoModelo; 
    
    @FXML
    private TextField campoPlaca;
    
    @FXML
    private void initialize() {
        dao = new Dao(Veiculo.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboVeiculos.setItems(listaOb);
    }
    
    @FXML
    private void editarVeiculo() {
        Veiculo temp = comboVeiculos.getSelectionModel().getSelectedItem();
        temp.setCodigo(Integer.valueOf(campoCodigo.getText()));
        temp.setMarca(campoMarca.getText());
        temp.setModelo(campoModelo.getText());
        temp.setPlaca(campoPlaca.getText());
        limparCampos();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Veiculo editado");
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
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
    
}
