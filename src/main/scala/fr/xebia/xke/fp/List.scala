package fr.xebia.xke.fp


sealed trait List[+A]{
	def tail:List[A] = drop(1)

	def drop(n: Int): List[A]

	def init: List[A] = this match{
		case Cons(a,Nil) => Nil
		case Cons(a,b)   => Cons(a,b.init)
		case Nil => this
	}
}

case class Cons[A](a: A, as:List[A]) extends List[A]{
	def drop(n:Int) = if (n < 1) {
		this
	} else as.drop(n-1)
}

case object Nil extends List[Nothing]{
	def drop(n:Int) = this
}