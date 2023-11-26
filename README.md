# ProjectTest
Формат входящих данных: 
- POST запрос на URL "http://localhost:8080/calculateFrequency" 
- Body запроса содержит JSON объект вида "ваша входная строка" 

Ограничения входящих параметров: 
- Максимальная длина входной строки - 1000 символов 
- Разрешенные символы во входной строке - от a до z (строчные буквы латинского алфавита) 

Формат исходящих данных: 
- JSON объект с результатом вычислений вида {"frequency": {"a": 5, "c": 4, "b": 1}} 

Ограничения исходящих параметров: 
- Максимальная длина JSON объекта с результатом - 1000 символов 
