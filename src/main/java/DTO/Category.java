/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Admin
 */ 
@Data
@Entity
@Table
public class Category {
    
    @Id
    private int CatagoryID;
    @Column
    private String Name;
    @Column
    private String Description;
    
    @OneToMany (mappedBy = "Category")  
    private List<Vegetable> listVegetable;
 
    @Override
    public String toString()
    {
        return this.Name;
    }
}
