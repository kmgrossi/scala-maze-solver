/**
  * Created by kevin on 3/3/2017.
  */
import scala.collection.mutable

class DFS (maze: Maze, start: MazeNode, end: MazeNode) {

  def dfssolver(maze: Maze, start: MazeNode): mutable.MutableList[MazeNode] = {

    val stack = new scala.collection.mutable.Stack[MazeNode]
    val startingNode = start

    startingNode.prevNode = null
    startingNode.state = NodeState.VISITED
    stack.push(startingNode)

    while(stack.nonEmpty){
      val currentNode = stack.pop()

      if(currentNode.rowPos == end.rowPos && currentNode.colPos == end.colPos) {
        val path = mazePath(maze: Maze, currentNode: MazeNode)
        return path
      }

      val adjList = maze.getAdjacentMazeNodes(currentNode)

      for (node <- adjList) {
        val adjacentNode = node
        if (adjacentNode.state == NodeState.OPEN){
          adjacentNode.state = NodeState.VISITED
          stack.push(adjacentNode)
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
