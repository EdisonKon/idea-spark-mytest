import org.apache.spark.{SparkConf, SparkContext}

class WordCountByScala {
  def main(args: Array[String]): Unit = {
    val sconf = new SparkConf().setAppName("spark-wordcount-scala").setMaster("local");
    val sc = new SparkContext(sconf);
    val wc = sc.textFile("D://hello.txt").flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _);
    System.out.println(wc.collect());

  }
}
