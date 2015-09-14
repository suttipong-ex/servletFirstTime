/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.student.testwebservlet.controller;

import javax.persistence.EntityManager;
import th.co.geniustree.student.testwebservlet.model.stdBook;

/**
 *
 * @author suttipong
 */
public class InsertData {
    public static int Insert(String name,String phone,String email, EntityManager em){
        em.getTransaction().begin();
        stdBook Nphone = new stdBook();
        Nphone.setPhone(phone);
        Nphone.setName(name);
        Nphone.setEmail(email);        
        em.persist(Nphone);
        em.getTransaction().commit();
        return 1;
    }
}
