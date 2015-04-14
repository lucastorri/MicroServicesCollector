package msc

case class ServiceId(name: String, version: String)

case class Service(
  id: ServiceId,
  dependencies: Set[ServiceId],
  isLiveFrontEnd: Boolean = false
)