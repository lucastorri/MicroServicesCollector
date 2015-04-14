package msc.configuration

import msc.{Graph, Node}

trait Configuration {

  def nodes: Set[Node]

  def graph: Graph = Graph(nodes)

}
