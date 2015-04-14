package msc.configuration

import msc.Node

case class InMemoryConfiguration(nodes: Set[Node]) extends Configuration
