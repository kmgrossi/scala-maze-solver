import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/*
* Driver that runs the main application of the program in conjunction with all
* other classes.
* */
object Driver extends App{

    override def main(args: Array[String]): Unit = { //FIXME: overriding the main method is deprecated
        
        if (args.length != 2){
            throw new IllegalArgumentException("Must only contain two arguments.")
        }

        val fileInput = args(0)
        val fileOutput = args(1)

        val originalMaze = ImageIO.read(new File(fileInput))

        val maze = new Maze(originalMaze)


        //Following code tests that the picture's dimensions is being read accurately
        //printf("Photo size is %d x %d\n", photo1.getWidth, photo1.getHeight)

    }
}
