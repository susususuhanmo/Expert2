package IOFunction
import Utils.SqlServerUtils.ReadUtil.read
import TableList._
import org.apache.spark.sql.hive.HiveContext
/**
  * Created by Administrator on 2018/4/2 0002.
  */
object Reader {

  //读取函数
  def readBetaExpert(hiveContext: HiveContext) = read(betaExpertInfo,hiveContext)

}
