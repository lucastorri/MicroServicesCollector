package msc

object Graphs {

  val sa1 = ServiceId("service-a", "1")
  val sa2 = ServiceId("service-a", "2")
  val sb1 = ServiceId("service-b", "1")
  val sb2 = ServiceId("service-b", "2")
  val sc1 = ServiceId("service-c", "1")

  val n1 = Node("10.0.0.1", Set(
    Service(sa1, Set(sb1), false),
    Service(sa2, Set(sb2), true)
  ))

  val n2 = Node("10.0.0.2", Set(
    Service(sb1, Set(), false),
    Service(sb2, Set(sc1), false)
  ))

  val n3 = Node("10.0.0.3", Set(
    Service(sc1, Set(), false)
  ))

  val graph = Graph(Set(n1, n2, n3))

}
