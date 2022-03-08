package br.com.letscode.bookstore;

import br.com.letscode.bookstore.controller.HelloRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HelloRestController.class})
class HelloRestControllerUnitTest {

    private static final String HELLO = "Hello ";
    private static final String NAME = "Fulano";
    private static final String PATH_PARAM = ". Path Param";
    public static final String QUERY_PARAM = ". Using Query Param";

    @Autowired
    private HelloRestController controller;

    @Test
    void should_create_the_controller() {
        assertNotNull(controller);
    }

    @Test
    void should_get_hello_via_path_params() {
        var result = controller.getHelloViaPathParam(NAME);
        assertResult(result, PATH_PARAM);
    }

    @Test
    void should_get_hello_query_params() {
        var result = controller.getHelloViaQueryParam(NAME);
        assertResult(result, QUERY_PARAM);
    }

    private void assertResult(String result, String method) {
        var expectedResult = HELLO + NAME + method;

        assertNotNull(result);
        assertFalse(result.isBlank());
        assertEquals(expectedResult, result);
    }
}
