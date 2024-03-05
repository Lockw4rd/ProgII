
package app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import modelo.Operador;
import util.Dao;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class EditarOperadorController {
    
    @FXML
    private ComboBox<Operador> comboOperadores;
    private ObservableList<Operador> listaOb;
    private List<Operador> lista;
    private Dao<Operador> dao;
    
    @FXML
    private TextField campoNome; 
    
    @FXML
    private TextField campoEndereco; 
    
    @FXML
    private TextField campoLogin; 
    
    @FXML
    private TextField campoSenha;
    
    @FXML
    private void initialize() {
        dao = new Dao(Operador.class);
        lista = dao.listarTodos();
        listaOb = FXCollections.observableArrayList(lista);
        comboOperadores.setItems(listaOb);
    }
    
    @FXML
    private void editarOperador() {
        Operador temp = comboOperadores.getSelectionModel().getSelectedItem();
        temp.setNome(campoNome.getText());
        temp.setEndereco(campoEndereco.getText());
        temp.setLogin(campoLogin.getText());
        temp.setSenha(campoSenha.getText());
        limparCampos();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Operador editado");
        alert.show();
    }

    @FXML
    private void limparCampos(){
        campoNome.setText("");
        campoEndereco.setText("");
        campoLogin.setText("");
        campoSenha.setText("");
    }
    
    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
    
}
