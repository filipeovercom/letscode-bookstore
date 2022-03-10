package br.com.letscode.bookstore.integration.authors;

import br.com.letscode.bookstore.integration.infraestructure.SpringIntegrationTest;
import io.cucumber.java8.Pt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class FindAuthorsIntegrationTest extends SpringIntegrationTest implements Pt {

    private ResultActions result;

    public FindAuthorsIntegrationTest() {

        Dado("^que eu solicite os autores cadastrados$", () -> {
            log.info("Buscando autores cadastrados");
        });

        Quando("^executar a ação GET para o endpoint \"([^\"]*)\"$", (String endpoint) -> {
            result = mvc.perform(get(endpoint)).andDo(print());
        });

        Então("^deverá retornar os autores cadastros no sistema$", () -> {
            var resultParsed = new String(result.andReturn().getResponse().getContentAsByteArray());
            assertThat(resultParsed).isEqualTo("[]");
        });

        E("^o status da resposta deve ser \"([^\"]*)\"$", (String resultado) -> {
            result.andExpect(status().is(Integer.parseInt(resultado)));
        });
    }
}
