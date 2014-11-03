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
import model.db.dao.PetDao;
import model.db.dao.PetDaoJDBC;
import model.pet.Animal;

/**
 * FXML Controller class
 *
 * @author Vinicius
 */
public class CadsController implements Initializable {

    @FXML
    private Button fechar;
    @FXML
    private Button cadastrar;
    @FXML
    private TextField txtfnome;
    @FXML
    private TextField txtfpeso;
    @FXML
    private TextField txtfdata;
    @FXML
    private TextField txtftipo;



    private Animal pet;
    private PetDao dao;

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public TextField getTxtfnome() {
        return txtfnome;
    }

    public void setTxtfnome(TextField txtfnome) {
        this.txtfnome = txtfnome;
    }

    public TextField getTxtfpeso() {
        return txtfpeso;
    }

    public void setTxtfpeso(TextField txtfpeso) {
        this.txtfpeso = txtfpeso;
    }

    public TextField getTxtfdata() {
        return txtfdata;
    }

    public void setTxtfdata(TextField txtfdata) {
        this.txtfdata = txtfdata;
    }

    public TextField getTxtftipo() {
        return txtftipo;
    }

    public void setTxtftipo(TextField txtftipo) {
        this.txtftipo = txtftipo;
    }


    /**
     * Initializes the controller class.
     */
    @FXML
    private void fecharCad(ActionEvent event) {
        fechar.getScene().getWindow().hide();
    }

    @FXML
    private void cadastrarCad() {
        //quer adicionar
        boolean isEdit = pet != null;
        if (!isEdit) {
            pet = new Animal();
        }
        
            pet.setNome(txtfnome.getText());
            pet.setPeso(Float.parseFloat(txtfpeso.getText()));
            pet.setData(txtfdata.getText());
            pet.setTipo(txtftipo.getText());

            if (isEdit) {

                dao.update(pet);
                cadastrar.getScene().getWindow().hide();

            } else {

                dao.add(pet);
                cadastrar.getScene().getWindow().hide();
            }
    

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new PetDaoJDBC();
    }

}
