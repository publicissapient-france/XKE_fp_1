package fr.xebia.xke.fp


sealed trait List[+A]{
	def tail:List[A] = drop(1)

	def drop(n: Int): List[A]

	def init: List[A] = this match{
		case Cons(a,Nil) => Nil
		case Cons(a,b)   => Cons(a,b.init)
		case Nil => this
	}

	def foldRight[B](z: B)(f: (A, B) => B): B = this match{
		case Nil => z
		case Cons(x,xs) => f(x,xs.foldRight(z)(f))
	}

 	@annotation.tailrec
	final def foldLeft[B](z: B)(f: (B, A) => B): B = this match{
		case Nil => z
		case Cons(x,xs) => xs.foldLeft(f(z,x))(f)
	}

	def length: Int = foldRight(0)((a,b) => b + 1)
}

object List{
	def sum(ints: List[Int]): Int = 
		ints.foldLeft(0)((i,j) => i + j)

	def product(ints: List[Int]): Int = 
		ints.foldLeft(1)((i,j) => i * j)

	def addOne(list: List[Int]): List[Int] = list match{
		case Cons(x,xs) => Cons(x+1,addOne(xs))
		case Nil => Nil
	}
	def tostring(list: List[_]): List[String] = list match{
		case Cons(x,xs) => Cons(x.toString,tostring(xs))
		case Nil => Nil
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