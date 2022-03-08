package br.com.letscode.bookstore.service;

import br.com.letscode.bookstore.model.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PublisherServiceUnitTest {
    @Test
    void when_createPublisher_shouldReturnPublisher() {
        Publisher newPublisher = new Publisher("Let's Code", "Rua Qualquer");
        PublisherService publisherService = new PublisherService();
        Publisher createdPublisher = publisherService.create(newPublisher);

        Assertions.assertEquals(newPublisher.getAddress(), createdPublisher.getAddress());
        Assertions.assertEquals(newPublisher.getName(), createdPublisher.getName());
    }
}
