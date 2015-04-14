package msc

case class Graph(cluster: Set[Node]) {

  val services = cluster.flatMap(_.services)

  val ids: Set[ServiceId] = services.map(_.id)

  val live: Set[ServiceId] = services.filter(_.isLiveFrontEnd).map(_.id)

  private val idToService: Map[ServiceId, Service] = {
    services.map(s => s.id -> s).toMap
  }

  private val serviceToNodes: Map[ServiceId, Set[Node]] = {
    cluster.flatMap { n => n.services.map(_ -> n) }
      .groupBy { case (service, _) => service.id }
      .mapValues { pairs => pairs.map { case (_, node) => node } }
  }

  private val graph: Map[ServiceId, Set[ServiceId]] = {
    services
      .flatMap { s => s.dependencies.map(s -> _) }
      .groupBy { case (service, _) => service.id }
      .mapValues { pairs => pairs.map { case (_, dependency) => dependency } }
  }

  def service(id: ServiceId): Service = {
    idToService(id)
  }

  def dependencies(s: Service): Set[ServiceId] = {
    dependencies(s.id)
  }

  def dependencies(id: ServiceId): Set[ServiceId] = {
    graph.getOrElse(id, Set.empty)
  }

  def nodes(s: Service): Set[Node] = {
    nodes(s.id)
  }

  def nodes(id: ServiceId): Set[Node] = {
    serviceToNodes.getOrElse(id, Set.empty)
  }

}
