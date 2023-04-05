/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dmacc.beans.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	boolean existsByFirstNameAndLastName(String firstName, String lastName);
	
	Author findByFirstNameAndLastName(String firstName, String lastName);
}
