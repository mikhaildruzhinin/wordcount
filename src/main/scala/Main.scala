import scala.util.Try

object Main extends App {
  private val countedWords: Try[Map[String, Int]] = for {
    inputFilePath <- args.headOption.toRight(new RuntimeException("Input file path is required")).toTry
    text <- Reader(inputFilePath)
    parsedWords <- WordCounter.parseInputText(text)
    result <- Try(WordCounter.count(parsedWords))
  } yield result

  countedWords.fold(error => { println(error); sys.exit(1) }, result => println(result))
}
