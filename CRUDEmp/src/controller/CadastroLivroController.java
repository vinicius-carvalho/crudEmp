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
import model.db.dao.LivrosDaoJPA;
import model.livro.Livro;

/**
 * FXML Controller class
 *
 * @author Joao Carloss
 */
public class CadastroLivroController implements Initializable {

    private Livro livro;
    private LivrosDaoJPA dao = new LivrosDaoJPA();

    @FXML
    private TextField txtAutor, txtTitulo, txtEditora;
    @FXML
    private Button btnSalvar, btnCancelar;

    

    public TextField getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(TextField txtAutor) {
        this.txtAutor = txtAutor;
    }

    public TextField getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(TextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public TextField getTxtEditora() {
        return txtEditora;
    }

    public void setTxtEditora(TextField txtEditora) {
        this.txtEditora = txtEditora;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }


    public Livro getNewLivro() {
        
        livro.setAutor(txtAutor.getText().toString());
        livro.setTitulo(txtTitulo.getText().toString());
        livro.setEditora(txtEditora.getText().toString());

        return livro;
    }

    @FXML
    public void handlerSalvar(ActionEvent event) {

        boolean isEdit = livro != null;
        
        if (!isEdit) {
            livro = new Livro();
        }

        livro=getNewLivro();
        
        System.out.println(livro.getAutor());
        

        if (isEdit) {

            dao.update(livro);
            btnSalvar.getScene().getWindow().hide();

        } else {

            dao.add(livro);
            btnSalvar.getScene().getWindow().hide();
        }

    }

    @FXML
    public void handlerCancelar(ActionEvent event) {
        btnCancelar.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
