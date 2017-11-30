/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import persistence.User;

/**
 *
 * @author kmurr
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    private String id;
    private String password;
    private String status;
    @PersistenceContext(unitName = "Users")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    public LoginBean() {
    }
    public String getID() {
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
    public String getStatus() {
        return status;
    }
    
    public void login() {
         User user = em.find(User.class, id);
         if (user != null) {
             try {
                 byte[] salt = user.getSalt();
                 String saltString = new String(salt, "UTF-8");
                 String checkPass = saltString+password;
                 MessageDigest digest = MessageDigest.getInstance("SHA-256");
                 byte[] password_hashcode = digest.digest(checkPass.getBytes("UTF-8"));
                 if (Arrays.equals(password_hashcode, user.getPassword())) {
                     HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                     session.setAttribute("User", user);
                     status="user_login_success";
                 } else {
                    status="user_login_fail"; 
                 }
             } catch (Exception ex){
                 status="user_login_fail"; }
         } else {
             status="user_login_fail";
         }
    }
    
    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
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
    
    
}
