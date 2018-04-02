/**
  * Created by Administrator on 2018/4/2 0002.
  */
object test {
  def main(args: Array[String]): Unit = {
    val a = try
    {
      2/0
    }catch {
      case e => {
        println("Message"+e.getMessage)
        throw e
        null

      }

    }finally {
      println ("finally")
    }

    println("try结束" + a)
  }

}
