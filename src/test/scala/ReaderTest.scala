import org.scalatest.funsuite.AnyFunSuite

import java.io.FileNotFoundException
import scala.util.Success

class ReaderTest extends AnyFunSuite {
  test("read existing file") {
    val inputFilePath: String = "src/main/resources/file.txt"
    val result = Reader(inputFilePath)
    val expectedResult = Success("This is a text file. This is another sentence. Это текстовый файл. Это второе предложение.")
    assert(result == expectedResult)
  }

  test("read empty file") {
    val inputFilePath: String = "src/test/resources/empty_file.txt"
    val result = Reader(inputFilePath)
    val expectedResult = Success("")
    assert(result == expectedResult)
  }

  test("read not existing file") {
    val inputFilePath: String = "src/test/resources/no_file.txt"
    val result = Reader(inputFilePath)
    assertThrows[FileNotFoundException](result.get)
  }
}
