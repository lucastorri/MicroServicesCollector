package msc

import msc.claimer.Claimer
import msc.collector.MarkAndSweepCollector
import msc.configuration.InMemoryConfiguration
import org.scalatest.{MustMatchers, FlatSpec}
import scala.language.reflectiveCalls

class MicroServiceCollectorTest extends FlatSpec with MustMatchers {

  it must "graph, collect, and claim" in {

    val configuration = InMemoryConfiguration(cluster)
    val collector = new MarkAndSweepCollector
    val claimer = new Claimer {
      var claimed: Option[Set[Node]] = None
      override def claim(nodes: Set[Node]): Unit = claimed = Some(nodes)
    }

    val msc = new MicroServiceCollector(configuration, collector, claimer)

    claimer.claimed must be (None)
    msc.run()

    claimer.claimed must be (Some(Set(n1, n2)))
  }

  it must "not claim nodes that contain other services running" in {

    val configuration = InMemoryConfiguration(Graphs.cluster)
    val collector = new MarkAndSweepCollector
    val claimer = new Claimer {
      var claimed: Option[Set[Node]] = None
      override def claim(nodes: Set[Node]): Unit = claimed = Some(nodes)
    }

    val msc = new MicroServiceCollector(configuration, collector, claimer)

    claimer.claimed must be (None)
    msc.run()

    claimer.claimed must be (Some(Set()))
  }

  val sa1 = ServiceId("service-a", "1")
  val sa2 = ServiceId("service-a", "2")
  val sb1 = ServiceId("service-b", "1")
  val sb2 = ServiceId("service-b", "2")
  val sc1 = ServiceId("service-c", "1")

  val n1 = Node("10.0.0.1", Set(
    Service(sa1, Set(sb1), false)
  ))

  val n2 = Node("10.0.0.2", Set(
    Service(sb1, Set(), false)
  ))

  val n3 = Node("10.0.0.3", Set(
    Service(sc1, Set(), false)
  ))

  val n4 = Node("10.0.0.4", Set(
    Service(sa2, Set(sb2), true)
  ))

  val n5 = Node("10.0.0,5", Set(
    Service(sb2, Set(sc1), false)
  ))

  val cluster = Set(n1, n2, n3, n4, n5)

}
