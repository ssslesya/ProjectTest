package ru.olesya.ProjectTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import ru.olesya.ProjectTest.Model.InputData;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Map;

@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest
class ProjectTestApplicationTests {
		@Autowired
		private MockMvc mockMvc;

		@Autowired
		private ObjectMapper objectMapper;

		@Test
		void testCalculateFrequency() throws Exception {
			String inputString = "aaaaabcccc";
			Map<String, Integer> expectedResult = Map.of("a", 5, "c", 4, "b", 1);

			// Выполнение POST запроса на "/calculateFrequency" с входными данными, проверка результата
			mockMvc.perform(post("/calculateFrequency")
							.contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(new InputData(inputString))))
					.andExpect(status().isOk())
					.andExpect(content().json(objectMapper.writeValueAsString(Map.of("frequency", expectedResult))));
		}
	}
