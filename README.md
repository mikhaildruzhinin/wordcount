# wordcount

Утилита подсчета слов, принимает текстовый файл в качестве входных данных и возвращает карту слов и их частоты в файле.

## Установка и запуск

Для запуска утилиты необходимо скачать jar файл из [вкладки с релизами](https://github.com/mikhaildruzhinin/wordcount/releases) и использовать для запуска в командной строке следующую команду:

```
java "-Dfile.encoding=UTF-8" -jar wordcount-assembly-1.0.0.jar  path/to/input/file.txt
```
Вместо параметра `path/to/input/file.txt` необходимо указать абсолютный путь для входного файла.

Также есть возможность собрать утилиту из исходного кода, для этого нужно установить sbt и выполнить следующие команды:
```
git clone git@github.com:mikhaildruzhinin/wordcount.git
cd wordcount
sbt assembly
```
В результате будет получен jar файл, из которого можно запустить утилиту используя ту же команду.
