package msc.collector

import msc.{Graph, ServiceId}

import scala.collection.mutable

class MarkAndSweepCollector extends Collector {

  override def collect(g: Graph): Set[ServiceId] = {
    sweep(g, mark(g))
  }

  private def mark(g: Graph): Set[ServiceId] = {
    val marked = mutable.HashSet.empty[ServiceId]

    val traverse = mutable.ListBuffer.concat(g.live)

    while (traverse.nonEmpty) {

      val next = traverse.remove(0)
      if (!marked.contains(next)) {
        marked += next
        traverse ++= g.dependencies(next)
      }

    }

    marked.toSet
  }

  private def sweep(g: Graph, marked: Set[ServiceId]): Set[ServiceId] = {
    g.ids.filterNot(marked.contains)
  }

}
