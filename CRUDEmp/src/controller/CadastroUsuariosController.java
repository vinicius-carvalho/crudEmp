/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.db.dao.UsuarioDaoJPA;
import model.user.User;

/**
 * FXML Controller class
 *
 * @author Vinicius
 */
public class CadastroUsuariosController implements Initializable {
 
    private UsuarioDaoJPA dao = new UsuarioDaoJPA();
    private User user;

    
    
    @FXML
    private TextField txtNome, txtTelefone, txtDataNascimento, txtEndereco, txtEmail;
    @FXML
    private Button btnSalvar, btnCancelar;

    

    public TextField getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(TextField txtNome) {
        this.txtNome = txtNome;
    }

    public TextField getTxtTelefone() {
        return txtTelefone;
    }

    public void setTxtTitulo(TextField txtTelefone) {
        this.txtTelefone = txtTelefone;
    }

    public TextField getTxtDataNascimento() {
        return txtDataNascimento;
    }

    public void setTxtEditora(TextField txtDataNascimento) {
        this.txtDataNascimento = txtDataNascimento;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    public TextField getTxtEndereco() {
        return txtEndereco;
    }

    public void setTxtEndereco(TextField txtEndereco) {
        this.txtEndereco = txtEndereco;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }



    public User getNewUser() {
        
        user.setNome(txtNome.getText().toString());
        user.setTelefone(txtTelefone.getText().toString());
        user.setData(txtDataNascimento.getText().toString());
        user.setEmail(txtEmail.getText().toString());
        user.setEndereco(txtEndereco.getText().toString());

        return user;
    }

    @FXML
    public void handlerSalvar(ActionEvent event) {
        
        
          boolean isEdit = user != null;
        if (!isEdit) {
            user = new User();
        }
        
           user=getNewUser();
            

            if (isEdit) {

                dao.update(user);
                btnSalvar.getScene().getWindow().hide();

            } else {

                dao.add(user);
                btnSalvar.getScene().getWindow().hide();
            }
    
    }

      @FXML
    public void handlerCancelar(ActionEvent event) {
        btnCancelar.getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
  
       
    }

}
