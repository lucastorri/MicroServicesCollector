package msc

import org.scalatest.{FlatSpec, MustMatchers}
import Graphs._

class GraphTest extends FlatSpec with MustMatchers {

  it must "collect all services" in {
    graph.ids must equal (Set(sa1, sa2, sb1, sb2, sc1))
  }

  it must "identify live frontend instances" in {
    graph.live must equal (Set(sa2))
  }

  it must "track dependencies" in {
    graph.dependencies(sa1) must equal (Set(sb1))
  }

  it must "track nodes that contain a service" in {
    graph.nodes(sa1) must equal (Set(n1))
  }

}

