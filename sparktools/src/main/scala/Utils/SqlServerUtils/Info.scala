package Utils.SqlServerUtils

/**
  * Created by Administrator on 2018/4/2 0002.
  */
class DataBaseInfo (val url:String,val usr:String,val pwd:String,val dataBase:String) { }
class TableInfo (val dataBaseInfo: DataBaseInfo,val table:String){ }