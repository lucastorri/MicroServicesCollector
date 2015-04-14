package msc.claimer

import msc.Node

trait Claimer {

  def claim(nodes: Set[Node])

}
