/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;
import model.db.dao.LivrosDaoJPA;
import model.livro.Livro;

/**
 *
 * @author Vinicius
 */
public class MainControllerEmp implements Initializable {

    private LivrosDaoJPA dao;
    CadastroLivroController controller = new CadastroLivroController();

    @FXML
    private TableView<Livro> tbllivro;

    @FXML
    private TableColumn<Livro, String> tblColTitulo;

    @FXML
    private TableColumn<Livro, String> tblColAutor;

    @FXML
    private TableColumn<Livro, String> tblColEditora;

    @FXML
    private TableColumn<Livro, String> tblColEmprestado;

    @FXML
    private void cadLivro(ActionEvent event)throws IOException {

       
            Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroLivro.fxml"));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            
            stage.showAndWait();
            updateView();
        

      
        
    }

    @FXML
    private void editLivro(ActionEvent event) {

        try {
            Livro livro = tbllivro.getSelectionModel().getSelectedItem();

          
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroLivro.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            CadastroLivroController controller = loader.getController();
            controller.setLivro(livro);
            controller.getTxtAutor().setText(livro.getAutor());
            controller.getTxtEditora().setText(String.valueOf(livro.getEditora()));
            controller.getTxtTitulo().setText(livro.getTitulo());

            stage.showAndWait();

            updateView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void delLivro() {

        Livro livro = tbllivro.getSelectionModel().getSelectedItem();
        dao.remove(livro.getId());
        updateView();

    }
    
      @FXML
    private void listaUsuario() throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UsuariosCadastrados.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            

    }

    @FXML
    private void fecharMet(ActionEvent event) {
        Platform.exit();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblColTitulo.setCellValueFactory(new PropertyValueFactory<Livro, String>("titulo"));
        tblColAutor.setCellValueFactory(new PropertyValueFactory<Livro, String>("autor"));
        tblColEditora.setCellValueFactory(new PropertyValueFactory<Livro, String>("editora"));
        tblColEmprestado.setCellValueFactory(new PropertyValueFactory<Livro, String>("emprestado"));

        dao = new LivrosDaoJPA();

        updateView();

    }

    private void updateView() {
        tbllivro.setItems(FXCollections.observableArrayList(dao.list()));
        

    }

    @FXML
    private void handleBtnAdd(ActionEvent actionevent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroLivro.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

        updateView();

    }

}
