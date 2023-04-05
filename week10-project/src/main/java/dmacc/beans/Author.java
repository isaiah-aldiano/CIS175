/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package dmacc.beans;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Author {
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="author", fetch=FetchType.LAZY, orphanRemoval=true)
	private List<Book> books = new ArrayList<>();
	
	public Author() {}
	
	public Author(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
