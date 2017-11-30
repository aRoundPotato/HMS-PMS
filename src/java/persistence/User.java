/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kenmu
 */
@Entity
@Table(name="Users")
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private byte[] password;
    private byte[] salt;
    private String email;
    private String name;
    private int beepExt;
    private int phoneExt;
        
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public byte[] getPassword() {
        return password;
    }
    public void setPassword(byte[] password) {
        this.password = password;
    }
    public byte[] getSalt() {
        return salt;
    }
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
    public String getName(){
        return name;
    }
    public void setName(String name){
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
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.User[ id=" + id + " ]";
    }
    
}
