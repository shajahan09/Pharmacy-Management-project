/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.ProductDao;
import com.model.Parvez;
import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
@ManagedBean
@RequestScoped

public class ProductController {
    List<Parvez> productList = new ArrayList<>();
    String name;
    int qty;
    Float price;
    String self;
    String date;
    String search;
@PostConstruct
    public void inti() {
        productList = dao.getAllEmps();
//        System.out.println("---- size "+productList.size());
    }
    public List<String> testCompleteMethod(String input) {
//        System.out.println("------ "+input);
        List<String> suggesstions = new ArrayList<>();
        for(Parvez e: productList) {
            if(!e.getName().isEmpty() && e.getName().toLowerCase().contains(input.toLowerCase())) {
                suggesstions.add(e.getId()+"-"+e.getName());
            }
        }
        return suggesstions;
    }
    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public List<Parvez> getEmployeeList() {
        return productList;
    }

    public void setEmployeeList(List<Parvez> employeeList) {
        this.productList = employeeList;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    ProductDao dao =new ProductDao();

    public ProductDao getDao() {
        return dao;
    }

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }
    
    
    public List<Parvez> productList(){
        List<Parvez> products=dao.getproducts();
                
      return products;       
    }
    public String productUrl(){
        
        
        return "addProduct";
    }
    public String addProduct(){
        dao.insert(new Parvez(name,self,date,qty,price));
        return "addProduct";
    }
     public String back(){
        
        return "menu";
    }
      public String view(){
        
        return "allPro";
    }
       public String sell(){
        
        return "selling";
    }
           
    
}
