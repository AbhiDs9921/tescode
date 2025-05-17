import org.apache.spark.sql.SparkSession

object WordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("WordCountExample")
      .master("local[*]") // Use all cores
      .getOrCreate()

    val sc = spark.sparkContext

    // Replace with your file path or use Spark's sample files
    val textFile = sc.textFile("gs://bucket1/folder1/sample.txt")

    val counts = textFile
      .flatMap(line => line.split("\\W+")) // Split on non-word characters
      .filter(_.nonEmpty)
      .map(word => (word.toLowerCase, 1))
      .reduceByKey(_ + _)

    counts.collect().foreach(println)

    spark.stop()
  }
}