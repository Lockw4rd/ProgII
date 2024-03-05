
package app;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import modelo.Veiculo;
import modelo.Motorista;
import modelo.UsoVeiculo;
import util.Dao;

public class DevolucaoController {
    
    @FXML
    private DatePicker dateBox;
   
    @FXML
    private ComboBox<UsoVeiculo> comboUso;
    
    @FXML
    private ObservableList<UsoVeiculo> listaObU;
   
    private List<UsoVeiculo> listaU;
    
    private Dao<UsoVeiculo> daoU;

    @FXML
    private void initialize() {
        daoU = new Dao(UsoVeiculo.class);
        listaU = daoU.listarTodos();
        listaObU = FXCollections.observableArrayList(listaU);
        comboUso.setItems(listaObU);
    }
    
  
    @FXML
    private void devolucaoVeiculo() {
        UsoVeiculo uso = comboUso.getSelectionModel().getSelectedItem();
        LocalDate d = dateBox.getValue();
        
        try {
        uso.setDevolucao(d);
        daoU.alterar(uso);

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Veículo devolvido");
        alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Erro ao devolver veiculo");
            alert.show();
        }
        
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
    
}
