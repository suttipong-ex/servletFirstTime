/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.student.testwebservlet.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import th.co.geniustree.student.testwebservlet.model.stdBook;

/**
 *
 * @author suttipong
 */
public class ShowData {
        public static List<stdBook> show() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("th.co.geniustree.student_TestWebServlet_war_1.0-SNAPSHOTPU");
            EntityManager em = emf.createEntityManager();
            
            em.getTransaction().begin();
            TypedQuery<stdBook>query = (TypedQuery<stdBook>) em.createQuery("SELECT s FROM stdBook s");
            List<stdBook> stdBooks = query.getResultList();
            em.getTransaction().commit();
            for(stdBook b: stdBooks){
                System.out.println(b);
           }
            em.close();
         return stdBooks;
    }
}
