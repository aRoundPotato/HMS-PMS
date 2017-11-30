/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ResourceBundle;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.DBManager;
import persistence.Patient;

/**
 *
 * @author Kevin
 */
@Named(value = "patientBean")
@RequestScoped
public class PatientBean implements Serializable {
    private long govermentID;
    private Date dob;
    private char gender;
    private String maritalStatus;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private int externalDoctor;
    private Long insurance;
    private String kinFirstName;
    private String kinLastName;
    private String relationship;
    private String kinAddress;
    private String kinPhoneNumber;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @PersistenceContext(unitName = "HMS-PMS_PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public long getGovermentID() {
        return govermentID;
    }

    public void setGovermentID(long govermentID) {
        this.govermentID = govermentID;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public Long getInsurance() {
        return insurance;
    }

    public void setInsurance(Long insurance) {
        this.insurance = insurance;
    }
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getKinPhoneNumber() {
        return kinPhoneNumber;
    }

    public void setKinPhoneNumber(String kinPhoneNumber) {
        this.kinPhoneNumber = kinPhoneNumber;
    }
    
    public void registerPatient(){
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        String eContactName = firstName + lastName;
        Patient newPatient = new Patient(govermentID, firstName, lastName, dob, address, gender, phoneNumber, maritalStatus, insurance, eContactName, kinPhoneNumber, kinAddress);
        if(DBManager.addPatient(em, utx, newPatient)){
            status = (bundle.getString("addOk"));
        }
        else{
            status =(bundle.getString("addFail"));
        }
    }
    
    
}
