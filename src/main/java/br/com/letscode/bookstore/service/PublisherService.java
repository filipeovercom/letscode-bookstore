package br.com.letscode.bookstore.service;

import br.com.letscode.bookstore.model.entity.Publisher;

public class PublisherService {

    public Publisher create(Publisher newPublisher) {
        return new Publisher(newPublisher.getName(), newPublisher.getAddress());
    }
}
