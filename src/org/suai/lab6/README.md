# Ввод-вывод.
Нужно реализовать две небольшие программы.

### 1. Реализовать класс FormattedInput с двумя статическими функциями:  
Object[] scanf(String format). Читает с System.in.  
Object[] sscanf(String format, String in). Читает из строки in.  

format --- строка со спецификацией формата ввода (может быть несколько спецификаторов в одной строке, например, «%d %d %f»). Список спецификаторов:  
%d --- целое int  
%f --- дробное double  
%s --- строка  
%c --- символ  

Если ввод пользователя не соответствует спецификации, то функция запрашивает ввод повторно.  
Пример:  
```
main(..) {  
…………………...  
    Object vals[] = scanf(“%d %s %c”);  
…………………..  
}  
```
Ввод пользователя: 10 ten v  


### 2. Реализовать программу EncodingConverter для перекодирования текстовых файл из одной кодировки в другую. Программа должна получать параметры из командной строки и контролировать их корректность.  

Пример вызова: java EncodingConverter in.txt out.txt utf8 cp1251  
 
# Доп. задание

Сделать класс TranslateWriter, который записывает строку (по возможности с переводом) в файл (словарь (Dictionary) сделан с помощью HashMap).
```     
Dictionary dic = new Dictionary();
dic.add(“home”, “дом”);
….
TranlateWriter wr = new TranslateWriter(new FileWriter(“out.txt”), dic);
wr.write(“my sweet home”);
// out.txt -> my sweet дом
```
