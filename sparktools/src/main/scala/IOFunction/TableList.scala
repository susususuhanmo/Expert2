package IOFunction
import Utils.SqlServerUtils.{TableInfo,DataBaseInfo}
/**
  * Created by Administrator on 2018/4/2 0002.
  */
object TableList {
  //数据库信息
  val betaLogInfo = new DataBaseInfo("192.168.1.160:1433","fzj","fzj@zju","Log")
  val betaUnionInfo = new DataBaseInfo("192.168.1.160:1433","shm","shm@09201","CERSV4")
  val formalLogInfo = new DataBaseInfo("192.168.1.196:1433","shm","shm@09201","Log")
  val updateInfo = new DataBaseInfo("192.168.1.165:1433","shm","shm@092011","WangZhiHong")

  //表信息
  val betaExpertInfo = new TableInfo(betaLogInfo,"t_CandidateExpert")


}
