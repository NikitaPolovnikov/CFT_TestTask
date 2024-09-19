# **Тестовое задание. Курс JAVA**
# **Утилита фильтрации содержимого файлов** 

- Версия Java - 21.0.2
- Версия Apache Maven - 3.8.8
- Для сборки проекта использовался maven-jar-plugin версии 2.4

- Сторонние библиотеки не использовались.

## Сборка проекта в исполняемый jar-файл:
Находясь в корневой папке проекта выполнить команду "mvn package".
После этого исполняемый jar-файл будет создан в директории "target".

## Запуск утилиты
Для запуска утилиты входные файлы необходимо переместить в директорию target
или переместить util.jar в директорию содержащую входные файлы.

Утилита запускается с помощью выполнения команды:

"java -jar util.jar -s -a -p sample- in1.txt in2.txt"

Команда может содержать любые аргументы, соответствующие техническому заданию,  в любом порядке, а количество входных файлов не ограничено двумя.
