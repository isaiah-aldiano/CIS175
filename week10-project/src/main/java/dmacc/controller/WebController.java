/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Author;
import dmacc.beans.Book;
import dmacc.repository.AuthorRepository;
import dmacc.repository.BookRepository;

@Controller
public class WebController {
	@Autowired
	BookRepository repo;
	@Autowired
	AuthorRepository aRepo;
	
//	If no books are present in the database user is sent to add book page
//	Else user is shown allBooks available in database 
	@GetMapping({"/ViewAll", "/"})
		public String ViewAllBooks(Model model) {
			if(repo.findAll().isEmpty()) {
				return AddNewBook(model);
			} 
			
			model.addAttribute("books", repo.findAll());
		
			return "AllBooks";
		}

	@GetMapping("/AddBook")
		public String AddNewBook(Model model) {
			Book b = new Book();
			model.addAttribute("NewBook", b);
			
			return "AddBook";
		}
	
	@PostMapping("/AddBook")
		public String AddNewBook(@ModelAttribute Book b, Model model) {
			if(aRepo.existsByFirstNameAndLastName(b.getAuthor().getFirstName(), b.getAuthor().getLastName())) {
				System.out.println("found and shit");
			}
		
			repo.save(b);
			return "redirect:/Success";
		}
	
	@GetMapping("/Success")
		public String AddedSuccess() {
			return "redirect:/ViewAll";
		}
	
	@GetMapping("/Edit/{id}")
		public String EditBook(@PathVariable("id") long id, Model model) {
			Book b = repo.findById(id).orElse(null);
			model.addAttribute("NewBook", b);
			return "AddBook";
		}
	
	@PostMapping("/Update/{id}")
		public String UpdateBook(Book b, Model model) {
			if(aRepo.existsByFirstNameAndLastName(b.getAuthor().getFirstName(), b.getAuthor().getLastName())) {
				Author existingAuthor = aRepo.findByFirstNameAndLastName(b.getAuthor().getFirstName(), b.getAuthor().getLastName());
				b.setAuthor(existingAuthor);
			}
		
			repo.save(b);
			return "redirect:/Success";
		}
	
	@GetMapping("/Delete/{id}")
		public String DeleteBook(Book b, Model model) {
			repo.delete(b);
			return ViewAllBooks(model);
		}
	
	
	
	@GetMapping("/ViewAllAuthors")
	public String ViewAllAuthors(Model model) {
		if(aRepo.findAll().isEmpty()) {
			return ViewAllBooks(model);
		}
		
		model.addAttribute("authors", aRepo.findAll());
		
		return "AllAuthors";
	}
	
	@GetMapping("/DeleteAuthor/{id}")
		public String DeleteAuthor(Author a, Model model) {		
			aRepo.delete(a);
			return ViewAllAuthors(model);
		}
}
