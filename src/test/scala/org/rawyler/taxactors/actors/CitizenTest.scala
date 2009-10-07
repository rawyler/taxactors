package org.rawyler.taxactors.actors

import _root_.junit.framework.TestSuite
import _root_.org.junit.Test

class CitizenTest extends TestSuite {
  
  @Test def testEquality() {
    val foo = new Citizen("foo", 100000)
    val foo2 = new Citizen("foo", 100000)
    assert(foo == foo2)
  }
  
  @Test def testNotEqual() {
    val foo = new Citizen("foo", 100000)
    val bar = new Citizen("bar", 100000)
    assert(foo != bar)
  }
  
}
