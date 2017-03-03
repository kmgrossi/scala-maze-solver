import java.io.File                     // File I/O
import javax.imageio.ImageIO            // Load image from file
import java.awt.{Graphics2D, Color}

/** Class/Object containing main method
 * Driver that runs the main application of the program in conjunction with all
 * other classes.
 */
object Driver {

  def main(args: Array[String]): Unit = { 

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

    val startingPixel = new MazeNode(NodeState.OPEN, 43, 396, null)   // Our starting pixel located in the blue region
    val endingPixel = new MazeNode(NodeState.OPEN, 266, 397, null)
    val BFS = new BFS(maze, startingPixel)
    val pathNodes = BFS.bfssolver(maze, startingPixel)  // List of MazeNodes containing the solution path
    val newImage = originalMaze   // A copy of the original maze image to draw our solution on


    // Used to draw a green path representing the solution
    val green = new Color(0,255,0)
    val pathColor = green.getRGB


    for (node <- pathNodes){
      if(node != null)
        newImage.setRGB(node.rowPos, node.colPos, pathColor)
    }

    // Write the solved maze image to a file
    javax.imageio.ImageIO.write(newImage,"png", new java.io.File(fileOutput))

  } // end main method

} // end object Driver
