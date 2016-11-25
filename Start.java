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
import org.hibernate.Transaction;  
 
import org.hibernate.SessionFactory;  

import org.hibernate.cfg.Configuration;  
/**
 *
 * @author MSLCELTP1800
 */
public class Start {

    @Override
    public String toString() {
        return tabl;
    }

   
    private String tabl;
    private S1 emp;
public List getTable(){
     Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");
   SessionFactory factory=cfg.buildSessionFactory();
   Session session=factory.openSession();
     Transaction t=session.beginTransaction(); 
      Criteria c = session.createCriteria(Start.class);
    List al=new ArrayList();
    
        Iterator it=c.list().iterator();
        while(it.hasNext()){
            Start s=(Start) it.next();
            al.add(s);
        }
        t.commit();
    return al;  
}


    /**
     * @return the tabl
     */
    public String getTabl() {
        return tabl;
    }

    /**
     * @param tabl the tabl to set
     */
    public void setTabl(String tabl) {
        this.tabl = tabl;
    }

    /**
     * @return the tabName
     */
   public List dispT1(){
       S1 s=new S1();
       return s.disp();
   }
}