
package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import modelo.Motorista;
import util.Dao;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class EditarMotoristaController {
    
    @FXML
    private ComboBox<Motorista> comboMotoristas;
    private ObservableList<Motorista> listaOb;
    private List<Motorista> lista;
    private Dao<Motorista> dao;
    
    @FXML
    private TextField campoNome; 
    
    @FXML
    private TextField campoEndereco; 
    
    @FXML
    private TextField campoCnh; 
    
    @FXML
    private TextField campoSetor;
    
    @FXML
    private TextField campoCategoria;
    
    @FXML
    private void initialize() {
        dao = new Dao(Motorista.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboMotoristas.setItems(listaOb);
    }
    
    @FXML
    private void editarMotorista() {
        Motorista temp = comboMotoristas.getSelectionModel().getSelectedItem();
        temp.setNome(campoNome.getText());
        temp.setEndereco(campoEndereco.getText());
        temp.setCnh(Long.valueOf(campoCnh.getText()));
        temp.setSetor(campoSetor.getText());
        temp.setCategoria(campoCategoria.getText());
        limparCampos();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Motorista editado");
        alert.show();
    }

    @FXML
    private void limparCampos(){
        campoNome.setText("");
        campoEndereco.setText("");
        campoCnh.setText("");
        campoSetor.setText("");
        campoCategoria.setText("");
    }
    
    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
    
}
