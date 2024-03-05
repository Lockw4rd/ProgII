
package app;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Veiculo;
import util.Dao;

public class ListarVeiculoController {
    
    @FXML
    private TableView tabelaVeiculos;

    ObservableList<Veiculo> lista;

    @FXML
    private void initialize() {
        Dao<Veiculo> dao = new Dao(Veiculo.class);
        List<Veiculo> todos = dao.listarTodos();
        lista = FXCollections.observableArrayList(todos);

        TableColumn<Veiculo, String> colunaMarca = new TableColumn<>("Marca");
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        TableColumn<Veiculo, String> colunaModelo = new TableColumn<>("Modelo");
        colunaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn<Veiculo, String> colunaPlaca = new TableColumn<>("Placa");
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        
        tabelaVeiculos.getColumns().addAll(colunaMarca, colunaModelo, colunaPlaca);

        tabelaVeiculos.setItems(lista);
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
    
}
