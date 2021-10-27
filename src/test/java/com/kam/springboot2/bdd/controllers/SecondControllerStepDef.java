package com.kam.springboot2.bdd.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SecondControllerStepDef {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    ApplicationContext applicationContext;

    ResponseEntity<String> response;

    public SecondControllerStepDef() {
        super();
    }

    @Given("^the application is bootstraped$")
    public void ensureApplicationIsBootStrapped()
    {
        assertNotNull(applicationContext.getBean("secondController"));
    }

    @When("^I make a Get call$")
    public void makeCallToFirstController() throws MalformedURLException {
        response = testRestTemplate.getForEntity(
                new URL("http://localhost:" + port + "/secondProject/secondController").toString(), String.class);
    }

    @Then("^I should receive the expected output$")
    public void verifyReturnFromRestCall()
    {
        String expectedResponseBody = "Hello Second Service - second controller";

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponseBody, response.getBody());
    }
}
