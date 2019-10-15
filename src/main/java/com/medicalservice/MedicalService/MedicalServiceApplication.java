package com.medicalservice.MedicalService;

import com.medicalservice.MedicalService.model.Comment;
import com.medicalservice.MedicalService.model.Patient;
import com.medicalservice.MedicalService.repository.CommentRepository;
import com.medicalservice.MedicalService.repository.PatientRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Collections;

@SpringBootApplication
public class MedicalServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MedicalServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(
			PatientRepository patientRepository,
			CommentRepository commentRepository
	) {
		return args -> {
			Patient patient;
			Comment comment;
			patient = new Patient(
					"Taras",
					"Havryliv",
					"22/SEP/1998",
					"male",
					"Ukraine",
					"Ivano-Frankivsk",
					"2 Sivetska"
			);
			patientRepository.save(patient);
			comment = new Comment(
					patient.getId(),
					"take blood test",
					"22/SEP/2019"
			);
			commentRepository.save(comment);
			comment = new Comment(
					patient.getId(),
					"take leptin test",
					"22/SEP/2019"
			);
			commentRepository.save(comment);
			comment = new Comment(
					patient.getId(),
					"get blood test",
					"22/SEP/2019"
			);
			commentRepository.save(comment);
			comment = new Comment(
					patient.getId(),
					"get blood test",
					"22/SEP/2019"
			);
			commentRepository.save(comment);
			patient = new Patient(
					"Roksolana",
					"Havryliv",
					"06/APR/1997",
					"female",
					"Ukraine",
					"Ivano-Frankivsk",
					"2 Sivetska"
			);
			patientRepository.save(patient);
			comment = new Comment(
					patient.getId(),
					"take blood test",
					"06/APR/2019"
			);
			commentRepository.save(comment);
			comment = new Comment(
					patient.getId(),
					"get blood test",
					"06/APR/2019"
			);
			commentRepository.save(comment);
		};
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
