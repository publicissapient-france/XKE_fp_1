package fr.xebia.xke.fp

import org.scalatest.FunSpec
import org.scalatest.Matchers

class ListSpec extends FunSpec with Matchers {

	describe("A list"){
		it("can be empty"){
			Nil
		}

		it("can have one element"){
			new Cons(1,Nil)
		}

		it("can have more than 1 element"){
			new Cons(1,new Cons(2,Nil))
		}
	}

	describe("An empty list"){
		it("has no tail"){
			Nil.tail should be(Nil)
		}

		it("returns itself when try to drop some element"){
			Nil.drop(2) should be(Nil)	
		}
		it("has no init"){
			Nil.init should be(Nil)
		}
	}

	 describe("A non-empty list"){
	 	it("has a tail which is the list minus the first element"){
	 		val list = new Cons(1,new Cons(2,Nil))
	 		val listTail = list.tail

	 		listTail should be(new Cons(2,Nil))
	 	}

	 	it("returns a sublist by dropping elements from the left"){
	 		val list = new Cons(1,new Cons(2,new Cons(3,Nil)))
	 		val sublist = list.drop(2)

	 		sublist should be(new Cons(3,Nil))
	 	}

	 	it("returns Nil when dropping more elements than its length"){
	 		val list = new Cons(1,Nil)
	 		val sublist = list.drop(3)

	 		sublist should be(Nil)
	 	}
	 	it("init is the same list without the last one"){
			val list = new Cons(1,new Cons(2,new Cons(3,Nil)))
			val init = list.init

			init should be(new Cons(1,new Cons(2,Nil)))
		}
	 }
}
