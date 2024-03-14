import org.scalatest.funsuite.AnyFunSuite

class WordCounterTest extends AnyFunSuite {
  test("parse input text") {
    val text: String = "This! is? a test."
    val result = WordCounter().parseInputText(text)
    val expectedResult = List("this", "is", "a", "test")
    assert(result == expectedResult)
  }

  test("add new word occurrence") {
    val accumulator = Map("hello" -> 1)
    val result = WordCounter().countCurrentWord(accumulator, "world")
    val expectedResult = Map("hello" -> 1, "world" -> 1)
    assert(result == expectedResult)
  }

  test("increment existing word occurrences") {
    val accumulator = Map("hello" -> 1, "world" -> 1)
    val result = WordCounter().countCurrentWord(accumulator, "hello")
    val expectedResult = Map("hello" -> 2, "world" -> 1)
    assert(result == expectedResult)
  }

  test("count") {
    val text: String = "This is a test. This is another sentence."
    val result = WordCounter().count(text)
    val expectedResult = Map(
      "this" -> 2,
      "is" -> 2,
      "a" -> 1,
      "test" -> 1,
      "another" -> 1,
      "sentence" ->1
    )
    assert(result == expectedResult)
  }
}
