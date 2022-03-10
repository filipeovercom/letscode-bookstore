package br.com.letscode.bookstore.model;

import br.com.letscode.bookstore.model.entity.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PublisherUnitTest {

    @Test
    void when_getName_then_shouldNotReturnAnEmptyName() {
        String expected = "Let's Code";
        Publisher publisher = new Publisher(expected, "Rua Qualquer, 15, Bairro, Cidade");
        String result = publisher.getName();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void when_getAddress_then_shouldNotReturnAnEmptyAddress() {
        String expected = "Rua Qualquer, 15, Bairro, Cidade";
        Publisher publisher = new Publisher("Nome da Editora", expected);
        String result = publisher.getAddress();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void when_getName_then_shouldReturnANameWithMax120Chars() {
        String name = "Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code";
        Publisher publisher = new Publisher(name, "Rua Qualquer, 15, Bairro, Cidade");
        String result = publisher.getName();
        Assertions.assertTrue(result.length() <= 120);
    }

    @Test
    void when_getPublisher_then_shouldHaveAValidNameAndAddress() {
        String name = "Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code";
        String address = "Rua Qualquer, 15, Bairro, Cidade";
        Publisher publisher = new Publisher(name, address);
        Assertions.assertNotNull(publisher.getName());
        Assertions.assertFalse(publisher.getName().isBlank());
        Assertions.assertTrue(publisher.getName().length() <= 120);
        Assertions.assertNotNull(publisher.getAddress());
        Assertions.assertEquals(address, publisher.getAddress());
    }

    @Test
    void when_createPublisher_with_nullName_shouldFail() {
        String address = "Rua Qualquer, 15, Bairro, Cidade";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Publisher publisher = new Publisher(null, address);
        });
    }

    @Test
    void when_createPublisher_with_nullAddress_shouldFail() {
        String name = "Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code Let's Code";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Publisher publisher = new Publisher(name, null);
        });
    }
}
