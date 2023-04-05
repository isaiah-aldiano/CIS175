/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package dmacc.beans;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Getter
@Setter
@ToString
public class Book {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String publisher;
	private int pubYear;
	private int pageAmount;
	private String genre;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false, cascade = CascadeType.ALL)
	@JoinColumn(name="author_id", nullable = false)
	private Author author;
	
	public Book() {}
	
	public Book(String title, String publisher, int pubYear, int pageAmount, String genre) {
		this.title = title;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.pageAmount = pageAmount;
		this.genre = genre;
		
	}
	
	public Book(int id, String title, String publisher, int pubYear, int pageAmount, String genre) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.pageAmount = pageAmount;
		this.genre = genre;
	}
}

