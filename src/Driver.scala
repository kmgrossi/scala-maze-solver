import java.io.File                     // File I/O
import javax.imageio.ImageIO            // Load image from file
import java.awt.image.BufferedImage     // Stores image data

/** Class/Object containing main method
 * Driver that runs the main application of the program in conjunction with all
 * other classes.
 */
object Driver extends App {

  override def main(args: Array[String]): Unit = { // FIXME: overriding the main method is deprecated
     
    if (args.length != 2){
      throw new IllegalArgumentException("Must only contain two arguments.")
    }

    // val identifies constant variables (read-only and immutable)
    val fileInput = args(0)
    val fileOutput = args(1)

    // Read original maze image from file
    val originalMaze = ImageIO.read(new File(fileInput))

    // Constant variable object of class Maze
    val maze = new Maze(originalMaze)

    // Following code tests that the picture's dimensions is being read accurately
    //printf("Photo size is %d x %d\n", photo1.getWidth, photo1.getHeight)

  } // end main method

} // end object Driver
