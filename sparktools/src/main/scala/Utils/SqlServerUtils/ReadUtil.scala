package Utils.SqlServerUtils

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.hive.HiveContext

/**
  * Created by Administrator on 2018/4/2 0002.
  * Sql Server 读取工具
  *
  * 使用配置好的表信息（tableInfo）,和Spark建立的HiveContext读取Sql Server数据库。
  *
  */


object ReadUtil {
  def read(tableInfo: TableInfo, hiveContext: HiveContext): DataFrame = {
    try {
      val dataBaseInfo = tableInfo.dataBaseInfo
      val sqlUrl = "jdbc:sqlserver://" + dataBaseInfo.url + ";DatabaseName=" + dataBaseInfo.dataBase + ";"
      val option = Map("url" -> sqlUrl, "user" -> dataBaseInfo.usr, "password" -> dataBaseInfo.pwd, "dbtable" -> tableInfo.table,
        "driver" -> "com.microsoft.sqlserver.jdbc.SQLServerDriver")
      hiveContext.read.format("jdbc").options(option).load()
    } catch {
      case e => {
        println(tableInfo.table + "表读取出错，出错原因为" + e.getMessage)
        throw e
      }
    }

  }
}