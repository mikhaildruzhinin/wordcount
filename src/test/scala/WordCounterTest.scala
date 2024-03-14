import org.scalatest.funsuite.AnyFunSuite

import scala.util.Success

class WordCounterTest extends AnyFunSuite {
  test("parse input text") {
    val text: String = "Th#is! is? $ a test;.%…"
    val result = WordCounter.parseInputText(text)
    val expectedResult = Success(List("this", "is", "a", "test"))
    assert(result == expectedResult)
  }

  test("parse input text with cyrillic letters and numbers") {
    val text: String = "Эт#о тест.? $Это ещё; одно. предложение% 33…"
    val result = WordCounter.parseInputText(text)
    val expectedResult = Success(List("это", "тест", "это", "ещё", "одно", "предложение", "33"))
    assert(result == expectedResult)
  }

  test("parse empty text") {
    val text: String = ""
    val result = WordCounter.parseInputText(text)
    assertThrows[RuntimeException](result.get)
  }

  test("add new word occurrence") {
    val accumulator = Map("hello" -> 1)
    val result = WordCounter.countCurrentWord(accumulator, "world")
    val expectedResult = Map("hello" -> 1, "world" -> 1)
    assert(result == expectedResult)
  }

  test("increment existing word occurrences") {
    val accumulator = Map("hello" -> 1, "world" -> 1)
    val result = WordCounter.countCurrentWord(accumulator, "hello")
    val expectedResult = Map("hello" -> 2, "world" -> 1)
    assert(result == expectedResult)
  }

  test("count") {
    val parsedWords: Seq[String] = List("this", "is", "a", "test", "this", "is", "another", "sentence")
    val result = WordCounter.count(parsedWords)
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

  test("count with cyrillic letters") {
    val parsedWords: Seq[String] = List("это", "тест", "это", "ещё", "одно", "предложение")
    val result = WordCounter.count(parsedWords)
    val expectedResult = Map(
      "это" -> 2,
      "тест" -> 1,
      "ещё" -> 1,
      "одно" -> 1,
      "предложение" -> 1
    )
    assert(result == expectedResult)
  }
}
