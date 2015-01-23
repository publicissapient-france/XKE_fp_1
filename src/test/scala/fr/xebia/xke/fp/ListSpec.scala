package fr.xebia.xke.fp

import org.scalatest.FunSpec
import org.scalatest.Matchers

class ListSpec extends FunSpec with Matchers {

	describe("A list"){
		it("can be empty"){
			Nil
		}

		it("can have one element"){
			 Cons(1,Nil)
		}

		it("can have more than 1 element"){
			 Cons(1, Cons(2,Nil))
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
		it("as a sum of 0"){
			List.sum(Nil) should be(0)
		}
		it("as a sum of 1"){
			List.product(Nil) should be(1)
		}
		it("has a length of 0"){
			Nil.length should be(0)
		}
	}

	 describe("A non-empty list"){
	 	it("has a tail which is the list minus the first element"){
	 		val list = Cons(1, Cons(2,Nil))
	 		val listTail = list.tail

	 		listTail should be( Cons(2,Nil))
	 	}

	 	it("returns a sublist by dropping elements from the left"){
	 		val list = Cons(1, Cons(2, Cons(3,Nil)))
	 		val sublist = list.drop(2)

	 		sublist should be( Cons(3,Nil))
	 	}

	 	it("returns Nil when dropping more elements than its length"){
	 		val list = Cons(1,Nil)
	 		val sublist = list.drop(3)

	 		sublist should be(Nil)
	 	}
	 	it("init is the same list without the last one"){
			val list = Cons(1, Cons(2, Cons(3,Nil)))
			val init = list.init

			init should be( Cons(1, Cons(2,Nil)))
		}
		it("can sum a list of int"){
			List.sum(Cons(1, Cons(2, Cons(3, Nil)))) should be(6)
		}
		it("can product a list of int"){
			List.product(Cons(2, Cons(3, Cons(4, Nil)))) should be(24)
		}
		it("has a length"){
			Cons(2,Cons(3,Nil)).length should be(2)
		}
		it("add one to a list of ints"){
			val result = List.addOne(Cons(2,Cons(3,Nil)))

			result should be(Cons(3,Cons(4,Nil)))
		}
		it("can render elements as strings"){
			val result = List.tostring(Cons(1,Cons(2,Nil)))

			result should be(Cons("1",Cons("2",Nil)))
		}
		it("can be filtered"){
			val evens = Cons(1,Cons(2,Cons(3,Nil))).filter(p => p % 2 == 0)

			evens should be(Cons(2,Nil))
		}	
	 }
}
