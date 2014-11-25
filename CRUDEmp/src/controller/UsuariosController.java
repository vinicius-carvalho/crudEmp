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
import model.db.dao.UsuarioDaoJPA;
import model.user.User;

/**
 * FXML Controller class
 *
 * @author Vinicius
 */
public class UsuariosController implements Initializable {

    UsuarioDaoJPA dao = new UsuarioDaoJPA();
    @FXML
    private Button fechar;

    @FXML
    private TableView<User> tbluser;

    @FXML
    private TableColumn<User, String> tblColNome;

    @FXML
    private TableColumn<User, String> tblColTelefone;

    @FXML
    private TableColumn<User, String> tblColData;

    @FXML
    private TableColumn<User, String> tblColEndereco;

    @FXML
    private TableColumn<User, String> tblColEmail;

    @FXML
    private void cadUsuario(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroUsuario.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.showAndWait();
        updateView();

    }

    @FXML
    private void editUsuario(ActionEvent event) {

        try {
            User user = tbluser.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CadastroUsuario.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            CadastroUsuariosController controller = loader.getController();

            controller.setUser(user);
            controller.getTxtNome().setText(user.getNome());
            controller.getTxtTelefone().setText(String.valueOf(user.getTelefone()));
            controller.getTxtEmail().setText(user.getEmail());
            controller.getTxtEndereco().setText(user.getEndereco());
            controller.getTxtDataNascimento().setText(user.getData());

            stage.showAndWait();

            updateView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void delUsuario() {

        User user = tbluser.getSelectionModel().getSelectedItem();
        dao.remove(user.getId());
        updateView();

    }
    
     @FXML
    public void fechar(ActionEvent event) {
        fechar.getScene().getWindow().hide();
    }

    private void updateView() {
        tbluser.setItems(FXCollections.observableArrayList(dao.list()));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblColNome.setCellValueFactory(new PropertyValueFactory<User, String>("nome"));
        tblColTelefone.setCellValueFactory(new PropertyValueFactory<User, String>("telefone"));
        tblColData.setCellValueFactory(new PropertyValueFactory<User, String>("data"));
        tblColEndereco.setCellValueFactory(new PropertyValueFactory<User, String>("endereco"));
        tblColEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));

        dao = new UsuarioDaoJPA();

        updateView();
    }

}
