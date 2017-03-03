import java.io.File                     // File I/O
import javax.imageio.ImageIO            // Load image from file
import java.awt.image.BufferedImage     // Stores image data
import java.awt.{Graphics2D, Color}

/** Class/Object containing main method
 * Driver that runs the main application of the program in conjunction with all
 * other classes.
 */
object Driver {

  def main(args: Array[String]): Unit = { // FIXME: overriding the main method is deprecated
     
    if (args.length != 2){
      throw new IllegalArgumentException("Must only contain two arguments.")
    }

    // val identifies constant variables (read-only and immutable)
    val fileInput = args(0)   // Name of input image containing unsolved maze (Ex: ../maze.png)
    val fileOutput = args(1)  // Name of output image containing drawn path   (Ex: ../solvedmaze.png)

    // Read original maze image from file
    val originalMaze = ImageIO.read(new File(fileInput)) // reads file to obtain bufferedImage of original maze

    // Constant variable object of class Maze
    val maze = new Maze(originalMaze)

    val startingPixel = new MazeNode(NodeState.OPEN, 43, 396, null)
    val BFS = new BFS(maze, startingPixel)
    val pathNodes = BFS.bfssolver(maze, startingPixel)
    val newImage = originalMaze

    val green = new Color(0,255,0)
    val pathColor = green.getRGB

    for (node <- pathNodes){
      if(node != null)
        newImage.setRGB(node.rowPos, node.colPos, pathColor)
    }



    // TODO: Draw path showing solved path using pathNodes
    //val canvas = new BufferedImage(maze.mazeWidth, maze.mazeHeight, BufferedImage.TYPE_INT_RGB)
    // ^This might be more easily done just by copying the original maze and drawing on top of it.

    // Write image to a file
    javax.imageio.ImageIO.write(newImage,"png", new java.io.File("fileOutput.png"))

  } // end main method

} // end object Driver
