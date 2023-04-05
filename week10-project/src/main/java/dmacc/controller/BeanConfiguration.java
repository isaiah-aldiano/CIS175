/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dmacc.beans.Author;
import dmacc.beans.Book;

@Configuration
public class BeanConfiguration {
	@Bean
	@Scope("prototype")
	Book book() {
		Book newBook = new Book();
		return newBook;
	}
	
	@Bean
	Author author() {
		Author newAuthor = new Author();
		return newAuthor;
	}
}
