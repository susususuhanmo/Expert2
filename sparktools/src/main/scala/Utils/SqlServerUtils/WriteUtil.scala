package Utils.SqlServerUtils

import java.util.Properties

import org.apache.spark.sql.{DataFrame, SaveMode}

/**
  * Created by Administrator on 2018/4/2 0002.
  * Sql Server 写入工具
  *
  * 使用配置好的表信息（tabeInfo）,和待写入的DataFrame写入Sql Server数据库。
  *
  */
object WriteUtil {
  def write(data: DataFrame, tableInfo: TableInfo): Unit = {
    try {
      val dataBaseInfo = tableInfo.dataBaseInfo
      val connectProperties = new Properties()
      connectProperties.put("user", dataBaseInfo.usr)
      connectProperties.put("password", dataBaseInfo.pwd)
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance()
      val sqlUrl = "jdbc:sqlserver://" + dataBaseInfo.url + ";DatabaseName=" + dataBaseInfo.dataBase + ";"
      data.write.mode(SaveMode.Append).jdbc(sqlUrl, tableInfo.table, connectProperties)
    } catch {
      case e => println(tableInfo.table + "表写入出错，出错原因为" + e.getMessage)
        throw e
    }
  }
}
