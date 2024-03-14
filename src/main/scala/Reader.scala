import scala.io.Source
import scala.util.Try

object Reader {
  def apply(filePath: String): Try[String] = Try {
    val bufferedSource = Source.fromFile(filePath)
    val text = bufferedSource.getLines.mkString(" ")
    bufferedSource.close()
    text
  }
}
