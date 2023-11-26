package ru.olesya.ProjectTest;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping()
public class WebController {
    @PostMapping("/calculateFrequency")
    public Map<String, Integer> calculateFrequency(@RequestBody String inputString) {
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
