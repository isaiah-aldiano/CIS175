/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 10, 2023
 */
package dmacc.beans;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class member {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	@Autowired
	private membership status;
	
	public member() {
		
	}
	
	public member(int id, String name, int age, membership status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.status = status;
	}
	
	public member(String name, int age, membership status) {
		this.name = name;
		this.age = age;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public membership getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setStatus(membership status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "member [id=" + id + ", name=" + name + ", age=" + age + ", status=" + status + "]";
	}
}
