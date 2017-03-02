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
    maze.printMaze

    // Following code tests that the picture's dimensions is being read accurately
    //printf("Photo size is %d x %d\n", photo1.getWidth, photo1.getHeight)

    // TODO: Store path pixels from solution
    // TODO: Draw path showing solved path
    // Write image to a file
    //javax.imageio.ImageIO.write(new BufferedImage(...),"png", new java.io.File("fileOutput"))

  } // end main method

} // end object Driver
