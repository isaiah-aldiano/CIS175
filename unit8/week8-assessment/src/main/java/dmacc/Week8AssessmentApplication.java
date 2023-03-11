package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.member;
import dmacc.beans.membership;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.memberRepository;

@SpringBootApplication
public class Week8AssessmentApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Week8AssessmentApplication.class, args);
	}

	@Autowired
	memberRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		member newMember = appContext.getBean("member", member.class);
		membership newMembership = appContext.getBean("membership", membership.class);
		
		newMembership.setTypeOf("Staff");
		newMember.setAge(20);
		newMember.setName("Isaiah");
		newMember.setStatus(newMembership);
		
		repo.save(newMember);
		
		List<member> allMembers = repo.findAll();
		for (member someMember : allMembers) {
			System.out.println(someMember.toString());
		}
	}
}
