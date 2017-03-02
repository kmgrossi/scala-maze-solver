import NodeState.NodeState

class MazeNode(var state: NodeState, var rowPosition: Int, var colPosition: Int){

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

}

object NodeState extends Enumeration{
  type NodeState = Value
  val OPEN = Value("O")
  val CLOSED = Value(".")
  val VISITED = Value("V")
}