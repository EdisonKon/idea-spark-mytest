import java.net.URI
import java.io.IOException
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, LocatedFileStatus, Path, RemoteIterator}
class GetfilesName {

  var path = "/projects/luckydmp/msg/dt=2018-12-21/new_member_coupon_notused/"
  // var a = 0
  // // for( a <- 0 to 0){
  // //      var path1 = path.replaceAll("#",a+"")
  // //      var count = sc.textFile(path1).count();
  // //      println(path1 + "\t" + count )
  // // }
  // var count = sc.textFile(path).count();
  // println(path + "\t" + count )
  val conf: Configuration = new Configuration()
  var fs: FileSystem = null
  var files: RemoteIterator[LocatedFileStatus] = null
  def getFiles(HDFSPath: String) = {
    try {
      fs = FileSystem.get( new URI( HDFSPath ), conf )
    } catch {
      case e: IOException => {
        e.printStackTrace
      }
    }
    files
  }

  val allfile = getFiles( path )
  while (allfile.hasNext) {
    val file = allfile.next()
    println( file.getPath.getName )
  }
}
