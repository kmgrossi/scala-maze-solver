import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

/** Class for Node representation of maze images
 * (class description goes here)
 * @constructor
 * @param bufferedImage
 */
class Maze (bufferedImage: BufferedImage) {

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
                mazeArray(i)(j).nodeState = NodeState.CLOSED
            }
            else if (bufferedImage.getRGB(i, j) == white) {   // If pixel is a path
                mazeArray(i)(j).nodeState = NodeState.OPEN
            }
            else if (bufferedImage.getRGB(i, j) == blue) {    // If pixel is the end
                mazeArray(i)(j).nodeState = NodeState.VISITED
            }
            else if (bufferedImage.getRGB(i, j) == red) {     // If pixel is the start
                mazeArray(i)(j).nodeState = NodeState.VISITED
            }
            else {
                throw new NoSuchElementException
            }
        }
    }

    // Prints out maze representation as NodeStates
    for (i <- 0 until mazeHeight) {
        for (j <- 0 until mazeWidth) {
            print(mazeArray(j)(i))
        }
        println()
    }

} // end class Maze