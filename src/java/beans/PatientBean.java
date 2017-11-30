/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Kevin
 */
@Named(value = "patientBean")
@RequestScoped
public class PatientBean implements Serializable {
    private int govermentID;
    private Date dob;
    private char gender;
    private char maritalStatus;
    private String firstName;
    private String lastName;
    private String address;
    private int telephone;
    private int externalDoctor;
    private String kinFirstName;
    private String kinLastName;
    private String relationship;
    private String kinAddress;
    private int kinTelephone;

    public int getGovermentID() {
        return govermentID;
    }

    public void setGovermentID(int govermentID) {
        this.govermentID = govermentID;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(char maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getExternalDoctor() {
        return externalDoctor;
    }

    public void setExternalDoctor(int externalDoctor) {
        this.externalDoctor = externalDoctor;
    }

    public String getKinFirstName() {
        return kinFirstName;
    }

    public void setKinFirstName(String kinFirstName) {
        this.kinFirstName = kinFirstName;
    }

    public String getKinLastName() {
        return kinLastName;
    }

    public void setKinLastName(String kinLastName) {
        this.kinLastName = kinLastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getKinAddress() {
        return kinAddress;
    }

    public void setKinAddress(String kinAddress) {
        this.kinAddress = kinAddress;
    }

    public int getKinTelephone() {
        return kinTelephone;
    }

    public void setKinTelephone(int kinTelephone) {
        this.kinTelephone = kinTelephone;
    }
    
    public void registerPatient(){
        
    }
    
    
}
