import scala.util.Try

object Main extends App {
  for {
    inputFilePath <- args.headOption.toRight(new RuntimeException("Input file path is required")).toTry
    text <- Reader(inputFilePath)
    result <- Try(WordCounter().count(text))
    _ <- Try(println(result))
  } yield ()
}
