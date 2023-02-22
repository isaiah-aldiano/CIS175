/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gear_closets")
public class gearCloset {
	@Id
	@GeneratedValue
	private int id;
	private String closetName;
	@ManyToOne(cascade = CascadeType.MERGE)
	private climber someClimber;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<climbingGear> closetContents;
	
	public gearCloset() {
		
	}
	
	public gearCloset(int id, String closetName, climber climber, List<climbingGear> closetContents) {
		this.id = id;
		this.closetName = closetName;
		this.someClimber = climber;
		this.closetContents = closetContents;
	}
	
	public gearCloset(String closetName, climber climber, List<climbingGear> closetContents) {
		this.closetName = closetName;
		this.someClimber = climber;
		this.closetContents = closetContents;
	}
	
	public gearCloset(String closetName, climber climber) {
		this.closetName = closetName;
		this.someClimber = climber;
	}
	
	
	
	public int getId() {
		return id;
	}
	public String getClosetName() {
		return closetName;
	}
	public climber getSomeClimber() {
		return someClimber;
	}
	public List<climbingGear> getClosetContents() {
		return closetContents;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setClosetName(String closetName) {
		this.closetName = closetName;
	}
	public void setSomeClimber(climber someClimber) {
		this.someClimber = someClimber;
	}
	public void setClosetContents(List<climbingGear> closetContents) {
		this.closetContents = closetContents;
	}
	
	
	@Override
	public String toString() {
		return "gearCloset [id=" + id + ", closetName=" + closetName + ", someClimber=" + someClimber
				+ ", closetContents=" + closetContents + "]";
	}
}
