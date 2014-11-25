/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vinicius
 */
public class DaoFactory {
    
    protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudemp");
    
}
