package org.rawyler.taxactors.models

import _root_.junit.framework.TestSuite
import _root_.org.junit.Test

class CityTest extends TestSuite {
  
  @Test def testCitizensNotEmpty() {
    val citizens = City.citizens
    
    assert(!citizens.isEmpty)
  }
  
}
