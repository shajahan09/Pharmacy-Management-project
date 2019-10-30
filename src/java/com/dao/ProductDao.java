/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Parvez;

import java.util.ArrayList;
import java.util.List;
;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDao {
    SessionFactory sessionfactiory =HibernateUtil.getSessionFactory();
    public List<Parvez> getproducts(){
        List<Parvez>lists = new ArrayList<>();
        Session sess = sessionfactiory.openSession();
        Query query =sess.createQuery("From Parvez");
        lists = query.list();
        return lists;
    }
    public Parvez getProductById(int id){
        Parvez p = new Parvez();
        Session sess = sessionfactiory.openSession();
        Query query = sess.createQuery("From Product p where p.id= :productId");
        query.setParameter("productId", id);
        for(Object p1:query.list()){
            p = (Parvez) p1;
        }
        return p;
    }
    public void insert(Parvez p){
        Session sess = sessionfactiory.openSession();
        sess.beginTransaction();
        sess.getTransaction();
        sess.save(p);
        sess.getTransaction().commit();
        sess.close();
    }
     public List<Parvez> getAllEmps() {
         SessionFactory sessionFac = HibernateUtil.getSessionFactory();
        List<Parvez> emps = new ArrayList<>();
        Session sess = sessionFac.openSession();
        Query query = sess.createQuery("From Parvez");
        emps = query.list();
//        for(Employee e: emps) {
//            emps.add(e);
//        }
        sess.close();
        return emps;
    }
    
}
