
package app;

import java.io.IOException;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import app.App;
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
import util.ExclusaoException;

public class RetiradaController {
    
    @FXML
    private DatePicker dateBox;
   
    @FXML
    private ComboBox<Motorista> comboMotoristas;
    
    @FXML
    private ComboBox<Veiculo> comboVeiculos;
    
    private ObservableList<Motorista> listaObM;
    private ObservableList<Veiculo> listaObV;
    
    private List<Motorista> listaM;
    private List<Veiculo> listaV;
    
    @FXML
    
    private Dao<Motorista> daoM;
    private Dao<Veiculo> daoV;
    private Dao<UsoVeiculo> daoU;

    @FXML
    private void initialize() {
        daoM = new Dao(Motorista.class);
        daoV = new Dao(Veiculo.class);
        daoU = new Dao(UsoVeiculo.class);
        
        listaM = daoM.listarTodos();
        listaObM = FXCollections.observableArrayList(listaM);
        comboMotoristas.setItems(listaObM);
        
        listaV = daoV.listarTodos();
        listaObV = FXCollections.observableArrayList(listaV);
        comboVeiculos.setItems(listaObV);
    }
    
    @FXML
    private void retiradaVeiculo() {
        Motorista m = comboMotoristas.getSelectionModel().getSelectedItem();
        Veiculo v = comboVeiculos.getSelectionModel().getSelectedItem();
        LocalDate d = dateBox.getValue();
        
        try{
            UsoVeiculo uso = new UsoVeiculo();
            uso.setMotorista(m);
            uso.setVeiculo(v);
            uso.setRetirada(d);
            uso.setDevolucao(null);
            daoU.inserir(uso);
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Retirada confirmada");
            alert.show();
        } catch (Exception e) {
          Alert alert = new Alert(AlertType.ERROR);
          alert.setContentText("Erro ao retirar o veiculo");
          alert.show();     
        }
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
    
}
