package msc.collector

import msc.{Graph, Node, ServiceId}

trait Collector {

  def collect(g: Graph): Set[ServiceId]

  def claimable(g: Graph): Set[Node] = {
    //TODO it cannot claim a node that still has any service that is needed
    null
  }

}
