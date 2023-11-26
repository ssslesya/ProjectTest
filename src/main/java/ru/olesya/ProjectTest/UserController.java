package ru.olesya.ProjectTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.olesya.ProjectTest.Model.InputData;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @PostMapping("/calculateFrequency")
    public Map<String, Integer> calculateFrequency(@RequestBody InputData data) {
        String inputString = data.getInputString();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : inputString.toCharArray()) { // Подсчет частоты каждого символа во входной строке
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Map<String, Integer> result = new HashMap<>();
        frequencyMap.entrySet().stream()// Сортировка по частоте
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> result.put(String.valueOf(e.getKey()), e.getValue()));

        return result;
    }


}
