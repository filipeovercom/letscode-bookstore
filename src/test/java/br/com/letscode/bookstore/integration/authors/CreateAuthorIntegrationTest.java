package br.com.letscode.bookstore.integration.authors;

import br.com.letscode.bookstore.integration.infraestructure.SpringIntegrationTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.Pt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class CreateAuthorIntegrationTest extends SpringIntegrationTest implements Pt {

    private String payload;
    private ResultActions result;

    public CreateAuthorIntegrationTest() {

        Dado("^que desejo cadastrar um autor com as seguintes informações:$",
                (DataTable data) -> payload = dataTableToCreateRequest(data));

        Quando("^executar a ação POST para o endpoint \"([^\"]*)\"$", (String endpoint) -> {
            var request = post(endpoint).content(payload).contentType(MediaType.APPLICATION_JSON);
            result = mvc.perform(request).andDo(print());
        });

        Então("^o sistema deverá retornar o status \"([^\"]*)\"$", (String resultado) ->
                result.andExpect(status().is(Integer.parseInt(resultado))));

        E("^deverá apresentar \"([^\"]*)\" erros$", (String totalErrors) -> {
            var errors = Integer.parseInt(totalErrors);
            if(errors > 0) {
                result.andExpect(
                        jsonPath("$.errors.size()", equalTo(errors)));
            }
        });
    }

    private String dataTableToCreateRequest(DataTable data) throws JsonProcessingException {
        var row = data.transpose().asList();
        var request = mapper.createObjectNode();

        request.put("name", row.get(0));
        request.put("surname", row.get(1));

        return mapper.writeValueAsString(request);
    }
}
