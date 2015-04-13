package msc

import scala.collection.mutable

class Graph(nodes: Set[Node]) {

  val frontends: Set[Node] = nodes.filter(n => n.services.exists(_.isFrontEnd))


  val g = mutable.HashMap


  def serviceDependency: Map[Service, Set[Service]] = {



  }

}
