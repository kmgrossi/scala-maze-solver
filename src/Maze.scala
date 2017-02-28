import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class Maze (bufferedImage: BufferedImage){

  val mazeHeight = bufferedImage.getHeight
  val mazeWidth = bufferedImage.getWidth

  //Create 2d array of Strings using the dimensions of the maze.
  var mazeArray = Array.ofDim[String](mazeHeight,mazeWidth)

  //Decimal representations of Colors
  val white = 16777215
  val black = 268435455
  val blue = 255
  val red = 16711680


  var i,j = 0

  //Goes through the BufferedImage and then populates the 2D array of strings to be representative of the working layer.
  //TODO consider case for white,blue, and red.
  for (i <- 0 to mazeHeight){
    for(j <- 0 to mazeWidth){
      if(bufferedImage.getRGB(i,j) == black){
        mazeArray(i)(j) = "C"
      }
    }
  }

  i = 0
  j = 0

  for (i <- 0 to mazeHeight){
    for(j <- 0 to mazeWidth){
      print(mazeArray(i)(j))
    }
  }
}


