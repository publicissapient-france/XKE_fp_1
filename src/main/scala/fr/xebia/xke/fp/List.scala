package fr.xebia.xke.fp


trait List[A]{
	def tail:List[A] = drop(1)

	def drop(n: Int): List[A]
}

case class Cons[A](a: A, as:List[A]) extends List[A]{
	def drop(n:Int) = if (n < 1) {
		this
	} else as.drop(n-1)
}

case class Nil[A] extends List[A]{
	def drop(n:Int) = this
}