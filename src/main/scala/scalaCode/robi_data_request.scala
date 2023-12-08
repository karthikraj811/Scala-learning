
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{SparkSession}


object robi_data_request extends App {



    val spark = SparkSession.builder.appName("robi-data-request").getOrCreate()

    val df = spark.read.parquet("s3://ada-business-insights/prod/general/edotco_data_provision/BD/20230[7-9]*")

    df.select(substr("partition_1",1,6).alias("month")).distinct().show()




}
