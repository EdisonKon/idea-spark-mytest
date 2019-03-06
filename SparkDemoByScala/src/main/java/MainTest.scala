import scala.collection.mutable.ArrayBuffer

object MainTest {
  var numberArray = new Array[Int](10)
  var sreArray = new Array[String](10)
  var strArrayBuffer = new ArrayBuffer[String]()
  def main(args: Array[String]): Unit = {
//    for(a <- numberArray; b <- sreArray) println(a+b)//嵌套循环 100个
//    for((a,b) <- (numberArray zip sreArray)) println(a+b)//组合循环 10个
    strArrayBuffer+=("a","b","c")
    strArrayBuffer.foreach(a =>println(a))
    strArrayBuffer++=Array("Wllcome","To","XueTuWuYou")
    strArrayBuffer++=List("Wllcome2","To2","XueTuWuYou2")
    strArrayBuffer.foreach(a =>println(a))
    strArrayBuffer.trimEnd(3)
    strArrayBuffer.foreach(a =>println(a))
  }
}
