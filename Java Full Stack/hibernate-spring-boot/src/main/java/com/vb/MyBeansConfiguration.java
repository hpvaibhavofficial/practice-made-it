package com.vb;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.vb.algo.MynextPasswordHasher;
import com.vb.algo.MySimplePassHasher;
import com.vb.algo.PasswordHasher;

@Configuration
public class MyBeansConfiguration {
	
	@Bean
	PasswordHasher nextPassswordHasher()
	{
		return new MynextPasswordHasher();
	}
	@Bean 
	PasswordHasher simplePasswordHasher()
	{
		return new MySimplePassHasher();
	}
	
}