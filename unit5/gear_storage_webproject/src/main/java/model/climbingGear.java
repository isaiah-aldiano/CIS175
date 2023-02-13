/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 1, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "All_Gear")
public class climbingGear {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "ITEM")
	private String item;
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	@Column(name = "COST")
	private float cost;
	
	public climbingGear() {
		
	}
	
	public climbingGear(String item, String manufacturer) {
		this.item = item;
		this.manufacturer = manufacturer;
	}
	
	public climbingGear(String item, float cost, String manufacturer) {
		this.item = item;
		this.cost = cost;
		this.manufacturer = manufacturer;
	}
	
	public String getItem() {
		return item;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String getGearSummary() {
		return String.format(this.manufacturer + " - " + this.item + ": $%.2f", this.cost);
	}
}
