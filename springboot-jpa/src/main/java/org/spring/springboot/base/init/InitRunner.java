package org.spring.springboot.base.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("<========================this is a test=====================>");
		InitResource resource = InitResource.getInstance();
	}

}
