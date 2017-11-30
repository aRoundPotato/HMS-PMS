/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import persistence.User;
import persistence.Doctor;
import persistence.Nurse;
import persistence.ChargeNurse;

/**
 *
 * @author Kenneth
 */
@Named(value = "signUpBean")
@RequestScoped
public class SignUpBean {
    private String id;
    private String password;
    private String email;
    private String name;
    private int beepExt;
    private int phoneExt; 
    @PersistenceContext(unitName = "Users")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    private String status;
    private String EmployeeType;
    
    public SignUpBean() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBeepExt() {
        return beepExt;
    }
    public void setBeepExt(int beepExt) {
        this.beepExt = beepExt;
    }
    public int getPhoneExt() {
        return phoneExt;
    }
    public void setPhoneExt(int phoneExt) {
        this.phoneExt = phoneExt;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getEmployeeType() {
        return EmployeeType;
    }
    public void setEmployeeType(String EmployeeType) {
        this.EmployeeType = EmployeeType;
    }
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    public void addUser() {
        try {
            if(em.find(User.class, id)!=null){
                throw new Exception("User Already Exists");
            }
            User user;
            switch (EmployeeType.toLowerCase().replaceAll("\\s+","")){
                case "nurse":
                    user = new Nurse();
                    break;
                case "chargenurse":
                    user = new ChargeNurse();
                    break;
                case "doctor":
                    user = new Doctor();
                    break;
                default: throw new Exception("Invalid User Specification");

            }
            if(user!=null){
               user.setId(id);
               user.setName(name);
               user.setEmail(email);
               if(user instanceof ChargeNurse){
                   user.setBeepExt(beepExt);
                   user.setPhoneExt(phoneExt);
               }
            }
            final Random r = new SecureRandom();
            byte[] salt = new byte[32]; 
            r.nextBytes(salt);
            String saltStr = new String(salt, "UTF-8");
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] password_hashcode = digest.digest((saltStr+password).getBytes("UTF-8"));
            user.setSalt(salt);
            user.setPassword(password_hashcode);
            persist(user);
            status="user_create_success";
        } catch (Exception ex){
            status="user_create_fail";
        }
    }
    
}
