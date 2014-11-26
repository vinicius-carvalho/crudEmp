/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.db.dao.EmprestimoDaoJPA;
import model.emprestimo.Emprestimo;

/**
 * FXML Controller class
 *
 * @author Vinicius
 */
public class EmprestadosController implements Initializable {

    EmprestimoDaoJPA dao = new EmprestimoDaoJPA();
    
    @FXML
    private Button fechar;

    @FXML
    private TableView<Emprestimo> tblemp;

    @FXML
    private TableColumn<Emprestimo, String> tblColNome;

    @FXML
    private TableColumn<Emprestimo, String> tblColLivro;

    @FXML
    private TableColumn<Emprestimo, String> tblColDEmp;

    @FXML
    private TableColumn<Emprestimo, String> tblColDentrega;

    @FXML
    private TableColumn<Emprestimo, String> tblColTelefone;
    
    @FXML
    private TableColumn<Emprestimo, String> tblColEndereco;
    
    @FXML
    private TableColumn<Emprestimo, String> tblColEmail;

    @FXML
    private void cadEmp(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroEmprestimo.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.showAndWait();
        updateView();

    }

    @FXML
    private void editEmp(ActionEvent event) {

        try {
            Emprestimo emp = tblemp.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroEmprestimo.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            CadastroEmprestimoController controller = loader.getController();

            controller.setEmprestimo(emp);
            controller.getTxtCodLivro().setText(String.valueOf(emp.getCodLivro()));
            controller.getTxtCodUser().setText(String.valueOf(emp.getCodUser()));
            controller.getTxtDataEmprestimo().setText(String.valueOf(emp.getDataEmprestimo()));
            controller.getTxtDataEntrega().setText(String.valueOf(emp.getDataEntrega()));
          

            stage.showAndWait();

            updateView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void delEmp() {

        Emprestimo user = tblemp.getSelectionModel().getSelectedItem();
        dao.remove(user.getId());
        updateView();

    }
    
     @FXML
    public void fechar(ActionEvent event) {
        fechar.getScene().getWindow().hide();
    }

    private void updateView() {
        tblemp.setItems(FXCollections.observableArrayList(dao.list()));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tblColNome.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("nome"));
        tblColLivro.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("livro"));
        tblColDEmp.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("dataEmprestimo"));        
        tblColDentrega.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("dataEntrega"));        
        tblColTelefone.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("telefone"));
        tblColEndereco.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("endereco"));        
        tblColEmail.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("email"));        
                
                
        dao = new EmprestimoDaoJPA();

        updateView();
    }

}
