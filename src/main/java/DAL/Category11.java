/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Admin
 */ 

public class Category11 {
    
    private int CatagoryID;
   
    private String Name;
     
    private String Description;

    public Category11() {
    }

    public Category11(int CatagoryID, String Name, String Description) {
        this.CatagoryID = CatagoryID;
        this.Name = Name;
        this.Description = Description;
    }    
    public int getCatagoryID() {
        return CatagoryID;
    }

    public void setCatagoryID(int CatagoryID) {
        this.CatagoryID = CatagoryID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
