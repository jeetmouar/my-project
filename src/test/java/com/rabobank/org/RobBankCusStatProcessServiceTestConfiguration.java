package com.rabobank.org;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.rabobank.org.service.RobBankCusStatProcessService;

@Profile("test")
@Configuration
public class RobBankCusStatProcessServiceTestConfiguration {
	@Bean
	@Primary
	public RobBankCusStatProcessService productService() {

		return Mockito.mock(RobBankCusStatProcessService.class);
	}
}