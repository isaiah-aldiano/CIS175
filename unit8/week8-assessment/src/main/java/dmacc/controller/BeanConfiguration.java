/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 10, 2023
 */
package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dmacc.beans.membership;
import dmacc.beans.member;

@Configuration
public class BeanConfiguration {

	@Bean
	@Scope("prototype")
	member member() {
		member bean = new member();
		return bean;
	}
	
	@Bean
	@Scope("prototype")
	membership membership() {
		membership bean = new membership();
		return bean;
	}
}
