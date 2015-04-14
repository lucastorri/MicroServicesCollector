package msc.configuration

import msc.{Graph, Node}

trait Configuration {

  def cluster: Set[Node]

  def graph: Graph = Graph(cluster)

}
