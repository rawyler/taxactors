package org.rawyler.taxactors.actors

import org.specs._

class CitizenSpecification extends Specification {
	
  "Equality" should {
    "be true for the same name" in {
      val foo = new Citizen("foo", 100000)
      val foo2 = new Citizen("foo", 100000)
      assert(foo == foo2)
    }
  }
  
}
