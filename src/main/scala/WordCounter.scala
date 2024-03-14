import scala.util.Try

object WordCounter {
  def parseInputText(text: String): Try[Seq[String]] = Try {
    if (text.isEmpty) throw new RuntimeException("Empty file")

    text
      .toLowerCase
      .split(" ")
      .toList
      .map(_.replaceAll("""[^\p{L}\d]""", ""))
      .filter(_.nonEmpty)
  }

  def countCurrentWord(accumulator: Map[String, Int], word: String): Map[String, Int] = {
    val incrementCounter: Int => Map[String, Int] = (value: Int) => accumulator + (word -> (value + 1))

    accumulator.get(word)
      .fold(accumulator + (word -> 1))(incrementCounter)
  }

  def count(parsedWords: Seq[String]): Map[String, Int] = parsedWords
    .foldLeft(Map.empty[String, Int])((acc, word) => countCurrentWord(acc, word))
}
