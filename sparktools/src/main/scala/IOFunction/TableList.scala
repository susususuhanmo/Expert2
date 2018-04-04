package IOFunction
import Utils.SqlServerUtils.{TableInfo,DataBaseInfo}
/**
  * Created by Administrator on 2018/4/2 0002.
  */
object TableList {
  //数据库信息
  val logDb = new DataBaseInfo("192.168.1.160:1433","fzj","fzj@zju","Log")
  val V3Db = new DataBaseInfo("192.168.1.160:1433","fzj","fzj@zju","FzjV3")
  val unionDb = new DataBaseInfo("192.168.1.160:1433","shm","shm@09201","CERSV4")
  val formalLogDb = new DataBaseInfo("192.168.1.196:1433","shm","shm@09201","Log")
  val updateDb = new DataBaseInfo("192.168.1.165:1433","shm","shm@092011","WangZhiHong")

  //读出表信息
  val candidateExpertTable = new TableInfo(logDb,"t_CandidateExpert")
  val cnkiTable = new TableInfo(updateDb,"t_CNKI_UPDATE")
  val unionResourceTable = new TableInfo(unionDb,"t_UnionResource")
  val universityTable = new TableInfo(unionDb,"t_University2015")
  val clcTable = new TableInfo(V3Db,"CLCCCD")


  //写入表信息
  val tmpExpertLogTable = new TableInfo(logDb,"tmp_ExpertLog")
  val tmpJournalLogTable = new TableInfo(logDb,"tmp_JournalLog")
  val candidateResourceLogTable = new TableInfo(logDb,"t_CandidateResourceLog")
  val keyWordLogTable = new TableInfo(logDb,"t_KeywordLog")
  val paperAuthorLogTable = new TableInfo(logDb,"t_PaperAuthorLog")

}
