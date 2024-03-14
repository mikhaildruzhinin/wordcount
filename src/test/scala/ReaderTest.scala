import org.scalatest.funsuite.AnyFunSuite

import java.io.FileNotFoundException
import scala.util.{Failure, Success}

class ReaderTest extends AnyFunSuite {
  test("read existing file") {
    val inputFilePath: String = "src/main/resources/file.txt"
    val result = Reader(inputFilePath)
    val expectedResult = Success("This is a text file. This is another sentence.")
    assert(result == expectedResult)
  }

  test("read not existing file") {
    val inputFilePath: String = "src/main/resources/file2.txt"
    val result = Reader(inputFilePath)
    assertThrows[FileNotFoundException](result.get)
  }
}
