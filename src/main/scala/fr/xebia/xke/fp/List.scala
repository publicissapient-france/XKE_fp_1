package fr.xebia.xke.fp


trait List[A]{
	def tail:List[A]
}

case class Cons[A](elt: A, tail:List[A]) extends List[A]

case class Nil[A] extends List[A]{
	def tail = this
}