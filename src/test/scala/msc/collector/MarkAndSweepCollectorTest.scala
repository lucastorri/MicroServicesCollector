package msc.collector

import msc.Graphs._
import org.scalatest.{FlatSpec, MustMatchers}

class MarkAndSweepCollectorTest extends FlatSpec with MustMatchers {

  it must "find correct candidates for collection" in {

    (new MarkAndSweepCollector).collect(graph) must equal(Set(sa1, sb1))

  }

}
