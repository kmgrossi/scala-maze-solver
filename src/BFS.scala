
class BFS (maze: Maze, start: MazeNode){

  def bfssolver(maze: Maze, start: MazeNode): scala.collection.mutable.ArrayBuffer[MazeNode] = {

    val queue = new scala.collection.mutable.Queue[MazeNode]
    val startingNode = start

    startingNode.prevNode = null
    startingNode.state = NodeState.VISITED
    queue.enqueue(startingNode)

    while(queue.nonEmpty){
      var currentNode = queue.dequeue()

      if(currentNode.state == NodeState.END){
        val path = mazePath(maze: Maze, currentNode: MazeNode)
        return path
      }

      val adjList = maze.getAdjacentMazeNodes(currentNode)

      for (node <- adjList){
        var adjacentNode = node
        if (adjacentNode.state == NodeState.OPEN && adjacentNode != null){
          adjacentNode.state = NodeState.VISITED
          queue.enqueue(adjacentNode)
          adjacentNode.prevNode = currentNode
        }
      }
      currentNode.state = NodeState.VISITED
    }
    null //return null if no solution is found
  } //end solver

  def mazePath (maze: Maze, end: MazeNode): scala.collection.mutable.ArrayBuffer[MazeNode] = {

    var currentNode = end
    val path = new scala.collection.mutable.ArrayBuffer[MazeNode]

    while(currentNode != null){
      path.append(currentNode)
      currentNode = currentNode.prevNode
    }

    path
  }

} //end class
