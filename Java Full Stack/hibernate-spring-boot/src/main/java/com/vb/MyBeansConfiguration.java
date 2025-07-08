package com.vb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vb.algo.MySimplePassHasher;
import com.vb.algo.MynextPasswordHasher;
import com.vb.algo.PasswordHasher;

@Configuration
public class MyBeansConfiguration {
	
	
	@Bean
	PasswordHasher nextPasswordHasher()
	{
		return new MynextPasswordHasher();
		///injecting beans to contxt
	}
	@Bean
	PasswordHasher simplePasswordHasher()
	{
		return new MySimplePassHasher();
	}
	
	
}
