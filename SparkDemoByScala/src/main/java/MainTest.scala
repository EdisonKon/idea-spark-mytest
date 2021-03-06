import scala.collection.mutable.ArrayBuffer

object MainTest {
  //数组
  //定长
  var numberArray = new Array[Int](10)
  var sreArray = new Array[String](10)
  //非定长(buffer)
  var strArrayBuffer = new ArrayBuffer[String]()
  var intArrayVar = ArrayBuffer(7, 8, 9)
  //List
  var stringList = List("a", "b", "c")
  //var stringList = List.apply("a","b","c") //等同


  def main(args: Array[String]): Unit = {
    //    for(a <- numberArray; b <- sreArray) println(a+b)//嵌套循环 100个
    //    for((a,b) <- (numberArray zip sreArray)) println(a+b)//组合循环 10个
    /**
      * strArrayBuffer+=("a","b","c")//添加单个/多个元素
      *strArrayBuffer.foreach(a =>println(a))
      * strArrayBuffer++=Array("Wllcome","To","XueTuWuYou")//添加一个array
      * strArrayBuffer++=List("Wllcome2","To2","XueTuWuYou2")//添加一个list
      *strArrayBuffer.foreach(a =>println(a))
      *strArrayBuffer.trimEnd(3)//删除后三个
      *strArrayBuffer.foreach(a =>println(a))
      *intArrayVar.insert(0,6)//在第0个位置插入6,其余元素往后移
      *intArrayVar.insert(0,7,8,9)//在数组索引为0的位置插入元素7,8,9
      *intArrayVar.remove(0,4)//从索引0开始，删除4个元素
      *intArrayVar.toArray //转成定长数组
      *intArrayVar.toBuffer //转成非定长
      * //遍历
      * for(i  <- 0 to intArrayVar.length-1) println(i+":"+ intArrayVar(i))//0到 长度-1
      * for(i <- 0 until(intArrayVar.length)) println(i+":"+ intArrayVar(i))//0 到长度 不包含长度
      * for(a <- intArrayVar) println(a) //直接遍历
      * for(i <- 0 until(intArrayVar.length,2)) println(i+":"+ intArrayVar(i))//跳过步长 2
      * for(i<- (0 until(intArrayVar.length)).reverse) println(i+":"+ intArrayVar(i)) // 倒序输出
      * // 转换
      * var intArrayVar2 = for(i <- intArrayVar) yield i*2 //生成一个数组 是原数组元素*2 yield 生成 定长数组生成的 仍然是定长
      * var intArrayVar3 = for(i <- intArrayVar if i>7) yield i*2 // if过滤掉<=7的数据
      * //常用
      *intArrayVar.sum //求和
      *intArrayVar.max //最大值
      *intArrayVar.min //最小值
      *intArrayVar.toString() //得到 [I@141aba8
      * println(intArrayVar.mkString) //mkString无参 得到 789
      *intArrayVar.mkString(",") //得到 7,8,9
      *intArrayVar.mkString("<",",",">") //得到 <7,8,9>
      * //多维数组
      * var intMultiArray = Array(Array[Int](3,4),Array[Int](1,2))
      * intMultiArray(0)(1)//获取二维数组元素
      * //二维数组遍历
      * for (anArray : Array[Int]<- intMultiArray ; anint : Int <- anArray) println(anint)
      */
    //*****************************************************************************************
    //List操作
    //List构造方法
    //采用::及Nil进行列表构建
    var numsList = 1 :: (2 :: (3 :: (4 :: Nil)))
    //由于::操作符的优先级是从右往左的，因此上一条语句等同于下面这条语句
    var numsList2 = 1 :: 2 :: 3 :: 4 :: Nil
    //多重list
    val diagMatrix = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
    //遍历多重list
    for (anList: List[Int] <- diagMatrix; anint: Int <- anList) println(anint);
    //翻转 tail 返回除了第一个的所有元素
    //翻转 init 返回除了最后一个的所有元素
    //下面的结果一样
    print(numsList.tail.reverse)
    print(numsList.reverse.init)
    //是否为空
    numsList.isEmpty
    //获取第二个元素
    numsList.tail.head
    //连接操作 ::: 连接2个list生成新的list :: 单个元素连接list
    var t = List(1, 2, 3) ::: List(4, 5, 6)
    var t1 = 1 :: List(2, 3, 4)
    //丢弃前n个元素
    t1.drop(2)
    //获取前n个元素
    t1.take(1)
    //将列表分隔 两两分隔 (2)
    t.splitAt(2) //得到 List(1,2) List(3,4) List(5,6) 与 (nums.take(2),nums.drop(2)) 相同
    //Zip操作
    var nums = List(1, 2, 3, 4) //List(1, 2, 3, 4)
    var chars = List('1', '2', '3', '4') //List(1, 2, 3, 4)

    //返回的是List类型的元组(Tuple）
    var ziped = nums zip chars //得到 List((1,1), (2,2), (3,3), (4,4))
    //unzip
    print(ziped.unzip) //(List(1, 2, 3, 4),List(1, 2, 3, 4))

    //toString
    print(nums.toString()) // List(1, 2, 3, 4)
    //mkString
    nums.mkString(",") // 1,2,3,4
    //list伴生对象方法
    var l = List.apply(1,2,3,4)
    //range 范围
    List.range(1,6) //List(1, 2, 3, 4, 5)
    //range 范围带步长
    List.range(1,6,2) //List(1, 3, 5)
    //range 范围带步长 -1 向左进行跳步
    List.range(1,6,-1) //结果 List()
    //range 范围带步长 -1 向左进行跳步
    List.range(6,1,-1) //结果 List(6, 5, 4, 3, 2)
    //相同元素
    List.fill(5)("hey") //List(hey, hey, hey, hey, hey)

    //list.flatten，将列表平滑成第一个无素 压扁
    var xss = List(List('a', 'b'), List('c'), List('d', 'e'))
    xss.flatten //List(a, b, c, d, e)
    //列表连接
    List.concat(List('a', 'b'), List('c')) // List(a, b, c)

    //插入算法
    def isort(xs: List[Int]): List[Int] =
      if (xs.isEmpty) Nil
      else insert(xs.head, isort(xs.tail))

    def insert(x: Int, xs: List[Int]): List[Int] =
      if (xs.isEmpty || x <= xs.head) x :: xs
      else xs.head :: insert(x, xs.tail)

    //    isort(numsList);
  }
}
