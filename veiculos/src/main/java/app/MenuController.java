package app;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuController {
    
    @FXML
    private void cadastrarOperador() throws IOException {
        App.setRoot("novoOperador");
    }
    
    @FXML
    private void editaOperador() throws IOException {
        App.setRoot("editarOperador");
    }
    
    @FXML
    private void excluiOperador() throws IOException {
        App.setRoot("excluirOperador");
    }
    
    @FXML
    private void listaOperador() throws IOException {
        App.setRoot("listarOperador");
    }
    
    @FXML
    private void cadastrarMotorista() throws IOException {
        App.setRoot("novoMotorista");
    }
    
    @FXML
    private void editaMotorista() throws IOException {
        App.setRoot("editarMotorista");
    }
    
    @FXML
    private void excluiMotorista() throws IOException{
        App.setRoot("excluirMotorista");
    }
    
    @FXML
    private void listaMotorista() throws IOException{
        App.setRoot("listarMotorista");
    }
    
    @FXML
    private void cadastrarVeiculo() throws IOException {
        App.setRoot("novoVeiculo");
    }
    
    @FXML
    private void editaVeiculo() throws IOException {
        App.setRoot("editarVeiculo");
    }
    
    @FXML
    private void excluiVeiculo() throws IOException {
        App.setRoot("excluirVeiculo");
    }
    
    @FXML
    private void listaVeiculo() throws IOException {
        App.setRoot("listarVeiculo");
    }
    
    @FXML
    private void retirarVeiculo() throws IOException{
        App.setRoot("retiradaVeiculo");
    }
    
    @FXML
    private void devolverVeiculo() throws IOException{
        App.setRoot("devolucaoVeiculo");
    }
    
    @FXML
    private void buscarVeiculo() throws IOException{
        App.setRoot("buscaVeiculo");
    }
    
    @FXML
    private void sair(){
        Platform.exit();
        System.exit(0);
    }
    
}
