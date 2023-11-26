package ru.olesya.ProjectTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Map;
import java.util.Objects;

@AutoConfigureMockMvc
@ContextConfiguration(classes= ProjectTestApplication.class)
@WebMvcTest(WebController.class)
class ProjectTestApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCalculateFrequency() throws Exception {
		String inputString = "aaaaabcccc";
		String expectedResult = "{\"a\":5,\"c\":4,\"b\":1}";
		// Выполнение POST запроса на "/calculateFrequency" с входными данными, проверка результата
		String response = mockMvc.perform(post("/calculateFrequency")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(inputString)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		System.out.println(expectedResult.toString());
		System.out.println("\n"+response);
		if (!Objects.equals(expectedResult.toString(), response)) {
			throw new Exception("Неправильный ответ");
		}

	}
}
