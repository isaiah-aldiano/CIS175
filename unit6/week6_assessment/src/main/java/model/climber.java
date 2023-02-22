package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */

@Entity
@Table(name = "climbers")
public class climber {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public climber() {
		
	}
	
	public climber(String name) {
		this.name = name;
	}

	public climber(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "climber [id=" + id + ", name=" + name + "]";
	}
	
	
}
