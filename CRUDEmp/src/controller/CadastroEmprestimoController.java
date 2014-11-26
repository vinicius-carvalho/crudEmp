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

    private EmprestimoDaoJPA dao = new EmprestimoDaoJPA();

    @FXML
    Button btnSalvar, btnCancelar;

    @FXML
    TextField txtCodUser, txtCodLivro, txtDataEmprestimo, txtDataEntrega;

    @FXML
    Label lblErro;

    private Emprestimo emp;

    public Emprestimo getNewEmprestimo() {

        try {
            
            long codUser = Long.parseLong(txtCodUser.getText().toString());
            long codLivro = Long.parseLong(txtCodLivro.getText().toString());
            String dataEmprestimo = txtDataEmprestimo.getText().toString();
            String dataEntrega = txtDataEntrega.getText().toString();

            emp.setCodUser(codUser);
            emp.setCodLivro(codLivro);
            emp.setDataEmprestimo(dataEmprestimo);
            emp.setDataEntrega(dataEntrega);

            return emp;

        } catch (Exception e) {
            lblErro.setText("Erro: Código do Usuário ou Código Livro estão incorreto");
        }

        return null; //Criar método para lançar um expection
    }

    @FXML
    public void handlerSalvar(ActionEvent event) {

        boolean isEdit = emp != null;
        if (!isEdit) {
            emp = new Emprestimo();
        }

        emp = getNewEmprestimo();

        if (isEdit) {

            dao.update(emp);
            btnSalvar.getScene().getWindow().hide();

        } else {

            dao.add(emp);
            btnSalvar.getScene().getWindow().hide();
        }

    }

    @FXML
    public void handlerCancelar(ActionEvent event) {
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
        return emp;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emp = emprestimo;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
