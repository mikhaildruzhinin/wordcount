class WordCounter {
  def parseInputText(text: String): Seq[String] = text.split(" ")
    .toList
    .map(
      _.toLowerCase
        .replaceAll("""\p{Punct}""", "")
    )

  def countCurrentWord(accumulator: Map[String, Int], word: String): Map[String, Int] = {
    val incrementCounter: Int => Map[String, Int] = (value: Int) => accumulator + (word -> (value + 1))

    accumulator.get(word)
      .fold(accumulator + (word -> 1))(incrementCounter)
  }

  def count(text: String): Map[String, Int] = {
    val parsedWords = parseInputText(text)

    parsedWords.foldLeft(Map.empty[String, Int])((acc, word) => countCurrentWord(acc, word))
  }
}

object WordCounter {
  def apply(): WordCounter = new WordCounter()
}
