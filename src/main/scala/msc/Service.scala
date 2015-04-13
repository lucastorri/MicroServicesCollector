package msc

case class Service(name: String, version: String, dependencies: Set[Service], isFrontEnd: Boolean = false) {

  override def toString(): String = s"$name-$version"

}
