/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Book;

public interface BookRepository extends JpaRepository<Book, Long>{	
}
