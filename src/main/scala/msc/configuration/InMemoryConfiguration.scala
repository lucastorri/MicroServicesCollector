package msc.configuration

import msc.Node

case class InMemoryConfiguration(cluster: Set[Node]) extends Configuration
