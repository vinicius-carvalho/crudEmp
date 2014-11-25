/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.db.dao.EmprestimoDaoJPA;
import model.emprestimo.Emprestimo;

/**
 * FXML Controller class
 *
 * @author Joao Carloss
 */
public class CadastroEmprestimoController implements Initializable {

   
    @FXML
    Button btnSalvar, btnCancelar;
    
    @FXML
    TextField txtCodUser, txtCodLivro, txtDataEmprestimo, txtDataEntrega;
    
    @FXML
    Label lblErro;
    
    private Emprestimo emprestimo;
    private EmprestimoDaoJPA emprestimoDaoJPA;
    
    public Emprestimo getNewEmprestimo(){
        try {
            int codUser = Integer.parseInt(txtCodUser.getText().toString());
            int codLivro = Integer.parseInt(txtCodLivro.getText().toString());
            Date dataEmprestimo  = null;
            Date dataEntrega = null;
            
            emprestimo = new Emprestimo();
            emprestimo.setCodUser(codUser);
            emprestimo.setCodLivro(codLivro);
            emprestimo.setDataEmprestimo(dataEmprestimo);
            emprestimo.setDataEntrega(dataEntrega);
            
            return emprestimo;
            
        } catch (Exception e) {
            lblErro.setText("Erro: Código do Usuário ou Código Livro estão incorreto");
        }
        
        return null; //Criar método para lançar um expection
    }
    
 
    
    @FXML
    public void handlerSalvar (ActionEvent event){
        
        emprestimoDaoJPA = new EmprestimoDaoJPA();
        Emprestimo emprestimo = getNewEmprestimo();
        emprestimoDaoJPA.add(emprestimo);
        btnSalvar.getScene().getWindow().hide();
    }
    
    @FXML
    public void handlerCancelar (ActionEvent event){
        btnCancelar.getScene().getWindow().hide();
    }

    public TextField getTxtCodUser() {
        return txtCodUser;
    }

    public void setTxtCodUser(TextField txtCodUser) {
        this.txtCodUser = txtCodUser;
    }

    public TextField getTxtCodLivro() {
        return txtCodLivro;
    }

    public void setTxtCodLivro(TextField txtCodLivro) {
        this.txtCodLivro = txtCodLivro;
    }

    public TextField getTxtDataEmprestimo() {
        return txtDataEmprestimo;
    }

    public void setTxtDataEmprestimo(TextField txtDataEmprestimo) {
        this.txtDataEmprestimo = txtDataEmprestimo;
    }

    public TextField getTxtDataEntrega() {
        return txtDataEntrega;
    }

    public void setTxtDataEntrega(TextField txtDataEntrega) {
        this.txtDataEntrega = txtDataEntrega;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
