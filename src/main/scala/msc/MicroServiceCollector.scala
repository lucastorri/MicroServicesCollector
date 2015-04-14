package msc

import msc.claimer.Claimer
import msc.collector.Collector
import msc.configuration.Configuration

class MicroServiceCollector(configuration: Configuration, collector: Collector, claimer: Claimer) {

  def run(): Unit = {

    val g = configuration.graph

    val idleServices = collector.collect(g)
    val idleNodes = g.cluster.filter(_.services.forall(s => idleServices.contains(s.id)))

    claimer.claim(idleNodes)
  }

}
