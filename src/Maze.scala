import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

/** Class for Node representation of maze images
 * Constructs a data structure of MazePixels into a 2D array of MazePixels
 * representing the final, traversable Maze.
 * @constructor create a maze given a bufferedImage representation of an unsolved maze image
 * @param bufferedImage
 */
class Maze(bufferedImage: BufferedImage) {

  val mazeHeight = bufferedImage.getHeight
  val mazeWidth = bufferedImage.getWidth

  //Create 2D array of Strings using the dimensions of the maze.
  var mazeArray = Array.ofDim[MazeNode](mazeHeight, mazeWidth)

  for (i <- 0 until mazeHeight) {
    for(j <- 0 until mazeWidth) {
      // Initializes each location with an open Node
      mazeArray(i)(j) = new MazeNode(NodeState.OPEN, i, j)
    }
  }

  //Decimal representations of Colors used in the maze image
  val white = -1
  val black = -16777216
  val blue = -16776961
  val red = -65536

  //Goes through the BufferedImage and then populates the 2D array of strings to be representative of the working layer.
  for (i <- 0 until mazeHeight) {
    for (j <- 0 until mazeWidth) {
      if (bufferedImage.getRGB(i, j) == black) {        // If pixel is a wall
        mazeArray(i)(j).state = NodeState.CLOSED
      }
      else if (bufferedImage.getRGB(i, j) == white) {   // If pixel is a path
        mazeArray(i)(j).state = NodeState.OPEN
      }
      else if (bufferedImage.getRGB(i, j) == blue) {    // If pixel is the start
        mazeArray(i)(j).state = NodeState.VISITED
      }
      else if (bufferedImage.getRGB(i, j) == red) {     // If pixel is the end
        mazeArray(i)(j).state = NodeState.END
      }
      else {
        throw new NoSuchElementException
      }
    }
  }

  def getAdjacentMazeNodes(node: MazeNode): Array[MazeNode] = {
    var row = node.rowPos
    var col = node.colPos
    var adj = new Array[MazeNode](4)

    adj(0) = if (col-1 < 0) null else mazeArray(row)(col-1)
    adj(1) = if (row-1 < 0) null else mazeArray(row-1)(col)
    adj(2) = if (row+1 > mazeWidth) null else mazeArray(row+1)(col)
    adj(3) = if (col+1 > mazeHeight) null else mazeArray(row)(col+1)

    for (n <- adj)
      print(n) // DEBUG ONLY

    adj // Returned without need for return keyword
  }

  // Prints out maze representation as NodeStates
  def printMaze: Unit = {
    for (i <- 0 until mazeHeight) {
      for (j <- 0 until mazeWidth) {
        print(mazeArray(j)(i) + i.toString + j.toString)
      }
      println()
    }    
  }

} // end class Maze