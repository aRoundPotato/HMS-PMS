/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="Patients")
public class Patient implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long govID;
    private String firstName;
    private String lastName;
    private Date dob;
    private String address;
    private char gender;
    private String phone;
    private String maritalStatus;
    private Long insuranceNum;
    private String eContactName;
    private String eContactPhone;
    private String eContactAddress;
    private enum status{WAITING,ADMITTED,DISCHARGED} ;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getGovID(){
        return govID;
    }
    public void setGovId(Long govID){
        this.govID=govID;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public Date getDob(){
        return dob;
    }
    public void setDob(Date dob){
        this.dob = dob;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public char getGender(){
        return gender;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getMaritalStatus(){
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }
    public Long getInsuranceNum(){
        return insuranceNum;
    }
    public void setInsuranceNum(Long insuranceNum){
        this.insuranceNum = insuranceNum;
    }
    public String geteContactName() {
        return eContactName;
    }
    public void seteContactName(String eContactName) {
        this.eContactName = eContactName;
    }
    public String geteContactPhone() {
        return eContactPhone;
    }
    public void seteContactPhone(String eContactPhone) {
        this.eContactPhone = eContactPhone;
    }
    public String geteContactAddress() {
        return eContactAddress;
    }
    public void seteContactAddress(String eContactAddress) {
        this.eContactAddress = eContactAddress;
    }
    
    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "persistence.Patient[ id=" + id + " ]";
    }
    
}
