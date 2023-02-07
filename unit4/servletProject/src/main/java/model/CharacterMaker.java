package model;
/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 5, 2023
 */

public class CharacterMaker {
	private String name;
	private String ability;
	private String animal;
	private String picPath;
	
	public CharacterMaker() {
		
	}
	
	public CharacterMaker(String name, String animal, String ability) {
		this.name = name;
		this.animal = animal;
		this.ability = ability;
	}
	
	public String getName() {
		return name;
	}
	public String getAbility() {
		return ability;
	}
	public String getAnimal() {
		return animal;
	}
	public String getPicPath() {
		return "images/" + this.animal + ".jpeg";
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
	public String characterInfo() {
		return this.name + " " + this.animal + " " + this.ability;
	}
	
}
