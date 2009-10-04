package org.rawyler.taxactors.actors

trait TaxPayer {
	def doTaxes() {
	  // println(this + " sleeping")
	  Thread.sleep((Math.random * 3000).toLong)
	  // println(this + " continue")
	}
}
