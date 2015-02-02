package fr.xebia.xke.fp

import org.scalatest.{FunSpec, Matchers}

class OptionSpec extends FunSpec with Matchers {
  //
  //	describe("An empty option"){
  //		it("can be mapped"){
  //			val o:Option[Int] = None
  //
  //			o.map(i => i + 1) should be(None)
  //		}
  //		it("can be flatMapped"){
  //			val o:Option[Int] = None
  //
  //			o.flatMap(i => Some(i + 1)) should be(None)
  //		}
  //		it("return the default value"){
  //			val o:Option[Int] = None
  //
  //			o.getOrElse(5) should be(5)
  //		}
  //		it("return the optional default value"){
  //			val o:Option[Int] = None
  //
  //			o.orElse(Some(5)) should be(Some(5))
  //		}
  //		it("can be filtered"){
  //			val o:Option[Int] = None
  //
  //			val even = o.filter(i => i % 2 == 0)
  //
  //			even should be(None)
  //		}
  //	}
  //	describe("A non-empty option"){
  //		it("can be mapped"){
  //			val o = Some(1)
  //
  //			o.map(i => i + 1) should be(Some(2))
  //		}
  //		it("can be flatMapped with some value"){
  //			val o = Some(1)
  //
  //			o.flatMap(i => Some(i + 1)) should be(Some(2))
  //		}
  //		it("can be flatMapped with non value"){
  //			val o = Some(1)
  //
  //			o.flatMap(i => None) should be(None)
  //		}
  //		it("return the wrapped value"){
  //			val o = Some(1)
  //
  //			o.getOrElse(5) should be(1)
  //		}
  //		it("return itself in orElse"){
  //			val o = Some(1)
  //
  //			o.orElse(Some(5)) should be(Some(1))
  //		}
  //		it("can be filtered out"){
  //			val o = Some(1)
  //
  //			val even = o.filter(i => i % 2 == 0)
  //
  //			even should be(None)
  //		}
  //		it("can be filtered in"){
  //			val o = Some(2)
  //
  //			val even = o.filter(i => i % 2 == 0)
  //
  //			even should be(Some(2))
  //		}
  //	}
}