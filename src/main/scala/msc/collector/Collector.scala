package msc.collector

import msc.{Graph, ServiceId}

trait Collector {

  def collect(g: Graph): Set[ServiceId]

}
