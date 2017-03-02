import NodeState.NodeState

/** Class defining Maze Nodes
 * Class for containing information about each pixel in the maze image
 * @constructor create a maze node with its state, row position, and column position
 * @param state       : the node's state (Open, Closed, or Visited)
 * @param rowPosition : the node's pixel row position
 * @param colPosition : the node's pixel column position
 */
class MazeNode(var state: NodeState, var rowPosition: Int, var colPosition: Int) { // class header and constructor

  var nodeState = state
  var rowPos = rowPosition
  var colPos = colPosition

  def canEqual(a: Any) = a.isInstanceOf[MazeNode]   
  override def equals(that: Any): Boolean = 
    that match {
      case that: MazeNode => that.canEqual(this) && this.hashCode == that.hashCode
      case _ => false
  }

  override def hashCode: Int = {
    val ourHash = if (state == null) 0 else state.hashCode
    super.hashCode + ourHash
  }

  override def toString: String = "" + nodeState + ""

} // end class MazeNode


/** Enumeration for Node States
 * @tparam OPEN    : pixel/node not yet traversed
 * @tparam CLOSED  : pixel/node cannot be traversed
 * @tparam VISITED : pixel/node already been traversed
 */
object NodeState extends Enumeration {
  type NodeState = Value
  val OPEN = Value("O")
  val CLOSED = Value(".")
  val VISITED = Value("V")
} // end NodeState