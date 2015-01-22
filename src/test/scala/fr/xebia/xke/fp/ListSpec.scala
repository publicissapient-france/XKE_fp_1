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
}