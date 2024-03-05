package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Operador;
import util.Dao;

public class ListarOperadorController {
    
    @FXML
    private TableView tabelaOperadores;

    ObservableList<Operador> lista;

    @FXML
    private void initialize() {
        Dao<Operador> dao = new Dao(Operador.class);
        List<Operador> todos = dao.listarTodos();
        lista = FXCollections.observableArrayList(todos);

        TableColumn<Operador, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Operador, String> colunaLogin = new TableColumn<>("Login");
        colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));

        TableColumn<Operador, String> colunaEndereco = new TableColumn<>("Endereco");
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        tabelaOperadores.getColumns().addAll(colunaNome, colunaLogin, colunaEndereco);

        tabelaOperadores.setItems(lista);
    } 

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
    
}
