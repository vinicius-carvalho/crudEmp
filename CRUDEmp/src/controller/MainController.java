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
import model.livros.Livro;

/**
 *
 * @author Vinicius
 */
public class MainController implements Initializable {

    private LivrosDaoJPA dao;
    CadsController controller = new CadsController();

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
    private void cadLivro(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroLivro.fxml"));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (Exception e) {

        }

    }

    @FXML
    private void editPetMet(ActionEvent event) {

        try {
            Livro pet = tbllivro.getSelectionModel().getSelectedItem();

            /*controller.getTxtflogin().setText(login);
             controller.getTxtfname().setText(name);
             controller.getTxtfphone().setText(phone);*/
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroLivro.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            CadsController controller = loader.getController();
            controller.setPet(pet);
            controller.getTxtfnome().setText(pet.getNome());
            controller.getTxtfpeso().setText(String.valueOf(pet.getPeso()));
            controller.getTxtfdata().setText(pet.getData());
            controller.getTxtftipo().setText(pet.getTipo());

            stage.showAndWait();

            updateView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void delPetMet() {

        Livro pet = tbllivro.getSelectionModel().getSelectedItem();

        dao.remove(pet.getId());
        updateView();

    }

    @FXML
    private void fecharMet(ActionEvent event) {
        Platform.exit();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblColTitulo.setCellValueFactory(new PropertyValueFactory<Livro, String>("nome"));
        tblColAutor.setCellValueFactory(new PropertyValueFactory<Livro, String>("peso"));
        tblColEditora.setCellValueFactory(new PropertyValueFactory<Livro, String>("data"));
        tblColEmprestado.setCellValueFactory(new PropertyValueFactory<Livro, String>("tipo"));

        dao = new PetDaoJDBC();

        updateView();

    }

    private void updateView() {
        tbllivro.setItems(FXCollections.observableArrayList(dao.list()));

    }

    @FXML
    private void handleBtnAdd(ActionEvent actionevent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroPet.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

        CadsController controller = loader.getController();

        updateView();

    }

}
