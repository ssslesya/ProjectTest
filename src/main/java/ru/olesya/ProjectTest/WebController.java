package ru.olesya.ProjectTest;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping()
public class WebController {
    @PostMapping("/calculateFrequency")
    public Map<String, Integer> calculateFrequency(@RequestBody String inputString) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) { // Подсчет частоты каждого символа во входной строке
            if(Character.isLetter(c)){
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        Map<String, Integer> result = new LinkedHashMap<>();
        frequencyMap.entrySet().stream()// Сортировка по частоте
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(e -> result.put(String.valueOf((e.getKey())), e.getValue()));
        return result;
    }


}
