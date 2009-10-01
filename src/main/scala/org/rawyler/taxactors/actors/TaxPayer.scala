package org.rawyler.taxactors.actors

trait TaxPayer {
	def doTaxes() {
	  Thread.sleep((Math.random * 5000).toLong)
	}
}
