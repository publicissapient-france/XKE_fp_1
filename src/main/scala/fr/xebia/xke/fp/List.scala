package fr.xebia.xke.fp


sealed trait List[+A]{
	
	def drop(n: Int): List[A] = this match{
		case Nil => 
			Nil
		
		case Cons(x, xs) => 
			if (n < 1) {
				this
			} else 
				xs.drop(n-1)
	}

	def init: List[A] = this match{
		case Cons(a,Nil) => Nil
		case Cons(a,b)   => Cons(a,b.init)
		case Nil => this
	}

	def map[B](f: (A => B)): List[B] = this match{
		case Cons(x,xs) => Cons(f(x) , xs.map(f))
		case Nil => Nil
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

	def length: Int = 
		foldRight(0)((a,b) => b + 1)

	def tail:List[A] = drop(1)		
}

object List{
	def sum(ints: List[Int]): Int = 
		ints.foldLeft(0)((i,j) => i + j)

	def product(ints: List[Int]): Int = 
		ints.foldLeft(1)((i,j) => i * j)

	def addOne(list: List[Int]): List[Int] = 
		list.map(i => i + 1)

	def tostring(list: List[_]): List[String] = 
		list.map(x => x.toString)
	

}

case class Cons[A](a: A, as:List[A]) extends List[A]

case object Nil extends List[Nothing]