package com.etiya.ecommercedemopair1;


import com.etiya.ecommercedemopair1.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair1.core.util.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.etiya.ecommercedemopair1.repository.abstracts"})
@RestControllerAdvice
public class EcommerceDemoPair1Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair1Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource(){
		// Veritabanı bağlantısı..
		// Dosyadan çekme işlemi..
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		// Veritabanına git
		// Select * from Languages Where code='tr' and key='greetings' isteğinden dönen cevap senin çevirindir.
		messageSource.setBasename("messages");
		return messageSource;
	}
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

//	@ExceptionHandler
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public String handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
//		return "Validation Exception Fırlatıldı";
//	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> errors = new HashMap<>();
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());

		}
		return new ErrorDataResult<Object>(errors,methodArgumentNotValidException.getClass().getSimpleName());
	}
	//-> Parametre olarak handle edeceği, yakalayacağı exception türünü veririz

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		return new ErrorDataResult<Object>(businessException.getMessage(),businessException.getClass().getSimpleName());
	}


}
