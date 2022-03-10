package br.com.letscode.bookstore.integration.infraestructure;

import io.cucumber.java8.Pt;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration
@AutoConfigureMockMvc
public class SpringContextConfiguration implements Pt {
}
