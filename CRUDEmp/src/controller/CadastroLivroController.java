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
import model.livros.Livro;

/**
 * FXML Controller class
 *
 * @author Joao Carloss
 */
public class CadastroLivroController implements Initializable {

    @FXML
    private TextField txtAutor, txtTitulo, txtEditora, txtQuantidade;
    @FXML
    private Button btnSalvar, btnCancelar;
    
    private Livro livro;
    private LivrosDaoJPA livrosDaoJPA;
    
    public Livro getNewLivro(){
        livro = new Livro();
        livro.setAutor(txtAutor.getText().toString());
        livro.setTitulo(txtTitulo.getText().toString());
        livro.setEditora(txtEditora.getText().toString());
        
        try {
            int quantidade = Integer.parseInt(txtQuantidade.getText().toString());
            livro.setQuantidade(quantidade);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return livro;
    }
    
    @FXML
    public void handlerSalvar(ActionEvent event){
        livrosDaoJPA = new LivrosDaoJPA();
        livro = getNewLivro();
        livrosDaoJPA.add(livro);
        btnSalvar.getScene().getWindow().hide();
    }
    
    @FXML
    public void handlerCancelar (ActionEvent event){
        btnCancelar.getScene().getWindow().hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
