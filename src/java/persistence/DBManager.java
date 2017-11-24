/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author kenmu
 */
public class DBManager {
    
    public static boolean addPatient(EntityManager em, UserTransaction utx, Patient p) {
        if(findPatientByID(em,p.getId()).equals(p)){
            try{
                utx.begin();
                em.persist(p);
                utx.commit();
                return true;
            } catch (Exception ex) {
            //something 
            }
        }
        return false;
    }
        
    public static Patient findPatientByID(EntityManager em, Long id){
        Patient p = em.find(Patient.class, id);
        return p;
    }
    
    public static List<Patient> findPatientByName(EntityManager em, String name){
        Query query = em.createQuery(
                "SELECT p FROM Patient p" +
                " WHERE p.FIRSTNAME = :name OR p.LASTNAME = :name");
        query.setParameter("name",name);
        List<Patient> results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        } 
        return results;
    }
    
    public static boolean addLog(EntityManager em, UserTransaction utx, Log l) {
        if(findLogByID(em,l.getId()).equals(l)){
            try{
                utx.begin();
                em.persist(l);
                utx.commit();
                return true;
            } catch (Exception ex) {
            //something 
            }
        }
        return false;
    }
    
    public static Log findLogByID(EntityManager em, Long id){
        Log l = em.find(Log.class, id);
        return l;
    }
    
    //TODO: Figure out how to query timestamp intervals
    /*
    public static List<Log> findLogByDate(EntityManager em, Date d){
        Query query = em.createQuery(
                "SELECT l FROM Log l" +
                " WHERE l.TIMESTAMP >= :date1 AND l.TIMESTAMPE <= :date2");
        query.setParameter("date1",d.toString()+(new Time(0,0,0).toString()));
        query.setParameter("date2",d.toString()+(new Time(23,59,59).toString()));
        List<Log> results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        } 
        return results;
    } */
    
    public static boolean addUser(EntityManager em, UserTransaction utx, User u) {
        if(findUserByID(em,u.getId()).equals(u)){
            try{
                utx.begin();
                em.persist(u);
                utx.commit();
                return true;
            } catch (Exception ex) {
            //something 
            }
        }
        return false;
    }
    
    public static User findUserByID(EntityManager em, Long id){
        User u = em.find(User.class, id);
        return u;
    }
    
    public static User findUserByUserName(EntityManager em, String username ){
        Query query = em.createQuery(
                "SELECT u FROM User u" +
                " WHERE u.NAME = :userName");
        query.setParameter("userName",username);
        Object result = query.getSingleResult();
        return (User)result;
    }
    
}
