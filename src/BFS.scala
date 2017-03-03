import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 *
 */
class BFS (maze: Maze, start: MazeNode) {

  def bfssolver(maze: Maze, start: MazeNode): mutable.MutableList[MazeNode] = {

    val queue = new scala.collection.mutable.Queue[MazeNode]
    val startingNode = start

    startingNode.prevNode = null
    startingNode.state = NodeState.VISITED
    queue.enqueue(startingNode)

    while(queue.nonEmpty){
      val currentNode = queue.dequeue()

      if(currentNode.rowPos == 266 && currentNode.colPos == 397) {
        val path = mazePath(maze: Maze, currentNode: MazeNode)
        return path
      }

      val adjList = maze.getAdjacentMazeNodes(currentNode)

      for (node <- adjList) {
        val adjacentNode = node
        if (adjacentNode.state == NodeState.OPEN){
          adjacentNode.state = NodeState.VISITED
          queue.enqueue(adjacentNode)
          adjacentNode.prevNode = currentNode
        }
      }
      currentNode.state = NodeState.VISITED
    }
    println("No sol")
    null //return null if no solution is found
  } //end solver

  def mazePath (maze: Maze, end: MazeNode): mutable.MutableList[MazeNode] = {

    var currentNode = end
    val path = mutable.MutableList[MazeNode]()

    while(currentNode != null) {
      path += currentNode
      currentNode = currentNode.prevNode
    }

    path
  }

} //end class
