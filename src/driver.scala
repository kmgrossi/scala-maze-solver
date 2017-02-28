/**
  * Created by kevin on 2/28/2017.
  */

/*
* Driver that runs the main application of the program in conjunction with all
* other classes.
* */
object driver extends App{

  override def main(args: Array[String]): Unit = {
    if (args.length != 2){
      throw new IllegalArgumentException("Must only contain two arguments.")
    }

    val fileInput = args[0]
    val fileOutput = args[1]





  }
}
