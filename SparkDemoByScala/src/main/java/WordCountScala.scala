import org.apache.spark.api.java.JavaRDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCountScala {
  def main(args: Array[String]): Unit = {
    if (args.length < 1)
    {
      System.err.println("Usage: <file>")
      System.exit(1)
    }
    val sconf = new SparkConf().setAppName("spark-wordcount-scala").setMaster("local");
    val sc = new SparkContext(sconf);
    val wc = sc.textFile(args(0)).flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _);
    System.out.println(wc.collect());
    wc.foreach(println);
  }
}
