package IOFunction
import Utils.SqlServerUtils.ReadUtil.read
import TableList._
import org.apache.spark.sql.hive.HiveContext
/**
  * Created by Administrator on 2018/4/2 0002.
  */
object Reader {

  //读取函数
  def readExpert(hiveContext: HiveContext) = read(candidateExpertTable,hiveContext)
    .map(row =>
      (
        (row.getString(row.fieldIndex("name")), cutStr(row.getString(row.fieldIndex("organization")), 4)),
        (row.getString(row.fieldIndex("kId")),
          row.getString(row.fieldIndex("subject")),
          row.getString(row.fieldIndex("keyword")),
          null)
      )
    )

  def readCnki(hiveContext: HiveContext) = read(cnkiTable,hiveContext)
    .filter("status!=2&&status!=6&&status!=10&&status!=14")
    .limit(50000)
    .cache()


  def readOrigin(yearFilter:String,hiveContext: HiveContext) = read(unionResourceTable,hiveContext)
    .filter("resourceCode = 'J'and " + yearFilter)
    .map(f => transformRdd(f))

  def readUniversity(hiveContext: HiveContext) = read(universityTable,hiveContext)
    .select("name", "province", "area", "english")
    .withColumnRenamed("english", "altOrganization")
    .withColumnRenamed("name", "university")
    .withColumnRenamed("area", "city")

  def readClc(hiveContext: HiveContext) = read(clcTable,hiveContext)
    .select("CLC_CODE", "CCD_NAME")

}
