object MainTest4SetMap {

  import scala.collection.mutable

  //scala中所有的集合都来自于scala.collection包及其子包mutable, immutable当中
  //在scala中，默认使用的都是immutable集合，如果要使用mutable集合，需要在程序中引入
  //由于immutable是默认导入的，因此要使用mutable中的集合的话
  //使用如下语句
  val mutableSet1 = mutable.Set(1, 2, 3)
  // scala.collection.mutable.Set[Int] = Set(1, 2, 3)
  //不指定的话，创建的是immutable 集合
  val mutableSet2 = Set(1, 2, 3)
  // scala.collection.immutable.Set[Int] = Set(1, 2, 3)

  //定义一个集合
  //这里使用的是mutable
  val numsSet = Set(3.0, 5)
  // scala.collection.mutable.Set[Double] = Set(5.0, 3.0)

  //向集中添加一个元素，同前一讲中的列表和数组不一样的是
  //，Set在插入元素时并不保元素的顺序
  //默认情况下，Set的实现方式是HashSet实现方式，
  //集中的元素通过HashCode值进行组织
  numsSet + 6
  //scala.collection.mutable.Set[Double] = Set(5.0, 6.0, 3.0)

  //遍历集
  for (i <- numsSet) println(i)
  5.0
  6.0
  3.0

  //如果对插入的顺序有着严格的要求，则采用scala.collection.mutalbe.LinkedHashSet来实现
  val linkedHashSet = scala.collection.mutable.LinkedHashSet(3.0, 5)
  // linkedHashSet: scala.collection.mutable.LinkedHashSet[Double] = Set(3.0, 5.0)

  linkedHashSet + 6
  // scala.collection.mutable.LinkedHashSet[Double] = Set(3.0, 5.0, 6.0)
  //直接初始化
  // ->操作符，左边是key,右边是value
  val studentInfo = Map("john" -> 21, "stephen" -> 22, "lucy" -> 20)
  //studentInfo: scala.collection.immutable.Map[String,Int] = Map(john -> 21, stephen -> 22, lucy -> 20)

  //immutable不可变，它不具有以下操作
  //studentInfo.clear()
  //<console>:10: error: value clear is not a member of scala.collection.immutable.Map[String,Int]
  //studentInfo.clear()
  //^
  //创建可变的Map
  val studentInfoMutable = scala.collection.mutable.Map("john" -> 21, "stephen" -> 22, "lucy" -> 20)
  //studentInfoMutable: scala.collection.mutable.Map[String,Int] = Map(john -> 21, lucy -> 20, stephen -> 22)
  //mutable Map可变，比如可以将其内容清空
  studentInfoMutable.clear()

  studentInfoMutable
  //res3: scala.collection.mutable.Map[String,Int] = Map()

  //遍历操作1
  for (i <- studentInfoMutable) println(i)
  /*
    (john,21)
    (lucy,20)
    (stephen,22)
  */
  //遍历操作2
  studentInfoMutable.foreach(e => {
    val (k, v) = e; println(k + ":" + v)
  }
  )
  /*
  john:21
  lucy:20
  stephen:22
   */
  //遍历操作3
  studentInfoMutable.foreach(e => println(e._1 + ":" + e._2))
  /*
    john:21
    lucy:20
    stephen:22
  */

  //定义一个空的Map
  val xMap = new scala.collection.mutable.HashMap[String, Int]()
  //xMap: scala.collection.mutable.HashMap[String,Int] = Map()

  //往里面填充值
  xMap.put("spark", 1)
  //res12: Option[Int] = None

  xMap
  //res13: scala.collection.mutable.HashMap[String,Int] = Map(spark -> 1)

  //判断是否包含spark字符串
  xMap.contains("spark")
  //res14: Boolean = true

  //-> 初始化Map，也可以通过 ("spark",1)这种方式实现(元组的形式）
  val xMap2 = scala.collection.mutable.Map(("spark", 1), ("hive", 1))
  //xMap: scala.collection.mutable.Map[String,Int] = Map(spark -> 1, hive -> 1)

  "spark" -> 1
  //res18: (String, Int) = (spark,1)

  //获取元素
  xMap2.get("spark")
  //res19: Option[Int] = Some(1)

  xMap2.get("SparkSQL")
  //res20: Option[Int] = None

  def main(args: Array[String]): Unit = {

  }
}
