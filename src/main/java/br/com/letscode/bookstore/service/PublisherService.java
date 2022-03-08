package br.com.letscode.bookstore.service;

import br.com.letscode.bookstore.model.Publisher;

public class PublisherService {

    public Publisher create(Publisher newPublisher) {
        Publisher result = new Publisher(newPublisher.getName(), newPublisher.getAddress());
        return result;
    }
}
