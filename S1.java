/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author MSLCELTP1800
 */
public class S1 {

    @Override
    public String toString() {
        return getId() + "    " + getName()+ "    " + getAge() + "    " + getAddress();
    }
    private int id;
    private String name;
    private int age;
    private String address;

   
    public List disp(){
    Configuration cfg=new Configuration();  
    cfg.configure("hibernate1.cfg.xml");
   SessionFactory factory=cfg.buildSessionFactory();
   Session session=factory.openSession();
     Transaction t=session.beginTransaction(); 
      Criteria c = session.createCriteria(S1.class);
    List al=new ArrayList();
    
        Iterator it=c.list().iterator();
        while(it.hasNext()){
            S1 s=(S1) it.next();
            al.add(s);
        }
        t.commit();
    return al;  
}
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
