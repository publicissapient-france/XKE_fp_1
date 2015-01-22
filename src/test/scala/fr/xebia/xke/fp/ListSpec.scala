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

	 describe("A non-empty list"){
	 	it("has a tail which is the list minus the first element"){
	 		val list = new Cons(1,new Cons(2,new Nil[Int]))	
	 		val listTail = list.tail

	 		listTail should be(new Cons(2,new Nil[Int]))
	 	}
	 }
	}
}