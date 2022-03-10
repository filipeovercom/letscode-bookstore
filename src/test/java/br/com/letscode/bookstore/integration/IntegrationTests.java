package br.com.letscode.bookstore.integration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "br.com.letscode.bookstore.integration.infraestructure",
                "br.com.letscode.bookstore.integration.authors",
                "br.com.letscode.bookstore.model"
        })
public class IntegrationTests {}
