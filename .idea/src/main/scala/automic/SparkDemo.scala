package automic

import org.apache.spark.sql.SparkSession

object SparkDemo{

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .master("local[1]")
      .appName("myTest")
      .getOrCreate()

    // this is just for testing......!!
    println("Hie my dear devvvvv rushi class..............")
  }

}