import scala.collection.mutable.ArrayBuffer

object MainTest {
  //定长
  var numberArray = new Array[Int](10)
  var sreArray = new Array[String](10)
  //非定长(buffer)
  var strArrayBuffer = new ArrayBuffer[String]()
  var intArrayVar=ArrayBuffer(1,1,2)

  def main(args: Array[String]): Unit = {
//    for(a <- numberArray; b <- sreArray) println(a+b)//嵌套循环 100个
//    for((a,b) <- (numberArray zip sreArray)) println(a+b)//组合循环 10个
    strArrayBuffer+=("a","b","c")//添加单个/多个元素
    strArrayBuffer.foreach(a =>println(a))
    strArrayBuffer++=Array("Wllcome","To","XueTuWuYou")//添加一个array
    strArrayBuffer++=List("Wllcome2","To2","XueTuWuYou2")//添加一个list
    strArrayBuffer.foreach(a =>println(a))
    strArrayBuffer.trimEnd(3)//删除后三个
    strArrayBuffer.foreach(a =>println(a))
    intArrayVar.insert(0,6)//在第0个位置插入6,其余元素往后移
    intArrayVar.insert(0,7,8,9)//在数组索引为0的位置插入元素7,8,9
    intArrayVar.remove(0,4)//从索引0开始，删除4个元素
    intArrayVar.toArray //转成定长数组
    intArrayVar.toBuffer //转成非定长




  }
}
