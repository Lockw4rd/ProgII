
package app;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import java.time.LocalDate;
import modelo.Veiculo;
import modelo.Motorista;
import modelo.UsoVeiculo;
import util.Dao;
import java.util.Objects;
import java.util.stream.Stream;
import java.io.Console;

public class BuscaController {
    
    @FXML
    private ListView<String> listaV;

    @FXML
    private ComboBox<Veiculo> comboVeiculos;

    @FXML
    private DatePicker dateBox;

    private Dao<Veiculo> daoV;

    private Dao<UsoVeiculo> daoU;
    
    @FXML
    private void initialize() {
        daoV = new Dao(Veiculo.class);
        daoU = new Dao(UsoVeiculo.class);
        List<Veiculo> listarVeiculo = daoV.listarTodos();
        ObservableList<Veiculo> listarObV = FXCollections.observableArrayList(listarVeiculo);
        comboVeiculos.setItems(listarObV);
    }
    
    @FXML
    private void buscaVeiculo() {
        Veiculo v = comboVeiculos.getSelectionModel().getSelectedItem();
        LocalDate d = dateBox.getValue();
        List<String> m = FXCollections.observableArrayList();

        try {
            List<UsoVeiculo> listarUso = daoU.listarTodos();

            for (UsoVeiculo uso : listarUso) {
                if (String.valueOf(v).equals(String.valueOf(uso.getVeiculo()))) {
                    if (String.valueOf(uso.getRetirada()).equals(String.valueOf(d))) {
                        m.add(uso.getMotorista().getNome() + " " + uso.getMotorista().getCnh());
                    }

                else if (String.valueOf(uso.getDevolucao()).equals(String.valueOf(d))) {
                    m.add(uso.getMotorista().getNome() + " " + uso.getMotorista().getCnh());
                }

                else if (d.isAfter(uso.getRetirada()) && d.isBefore(uso.getDevolucao())) {
                    m.add(uso.getMotorista().getNome() + " " + uso.getMotorista().getCnh());
                }
                    
                }
            }

            this.listaV.getItems().addAll(m);

            if (m.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Nenhum motorista retirou veiculo nesta data");
                alert.show();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erro na busca ocorrido");
            alert.show();
        }
    }

    @FXML
    private void voltarAoMenu() throws IOException {
        App.setRoot("menu");
    }
}  
