package fr.xebia.xke.fp

import org.scalatest.FunSpec
import org.scalatest.Matchers

class ListSpec extends FunSpec with Matchers {

	describe("A list"){
		it("can be empty"){
			new Nil[String]
		}

		it("can have one element"){
			new Cons(1,new Nil[Int])
		}

		it("can have more than 1 element"){
			new Cons(1,new Cons(2,new Nil[Int]))
		}
	}

	describe("An empty list"){
		it("has no tail"){
			new Nil[String].tail should be(new Nil[String])
		}

		it("returns itself when try to drop some element"){
			new Nil[String].drop(2) should be(new Nil[String])	
		}

	 describe("A non-empty list"){
	 	it("has a tail which is the list minus the first element"){
	 		val list = new Cons(1,new Cons(2,new Nil[Int]))
	 		val listTail = list.tail

	 		listTail should be(new Cons(2,new Nil[Int]))
	 	}

	 	it("returns a sublist by dropping elements from the left"){
	 		val list = new Cons(1,new Cons(2,new Cons(3,new Nil[Int])))
	 		val sublist = list.drop(2)

	 		sublist should be(new Cons(3,new Nil[Int]))
	 	}

	 	it("returns Nil when dropping more elements than its length"){
	 		val list = new Cons(1,new Nil[Int])
	 		val sublist = list.drop(3)

	 		sublist should be(new Nil[Int])
	 	}
	 }
	}
}