/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author kmurr
 */
@Entity
@Table(name="Users")
public class Doctor extends User implements Serializable {

}
