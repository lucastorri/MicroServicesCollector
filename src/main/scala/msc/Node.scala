package msc

case class Node(id: String, services: Set[Service]) {

  override def toString(): String = s"$id$services"

}