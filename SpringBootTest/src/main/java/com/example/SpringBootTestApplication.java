package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.example.repository.UserRepository;


@EnableAutoConfiguration
@ComponentScan
public class SpringBootTestApplication extends SpringBootServletInitializer implements CommandLineRunner{
	@Autowired
    MessageSource messageSource;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		userRepository.save(new User(null, "hoge", "pass", "0"));
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootTestApplication.class);
	}

	/**
	 * Beanバリデーション設定(message.propertiesを使用する)
	 * @return
	 */
	@Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(this.messageSource);
        return bean;
    }
}
