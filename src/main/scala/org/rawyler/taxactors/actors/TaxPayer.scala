package org.rawyler.taxactors.actors

trait TaxPayer {
	def doTaxes() {
	  Thread.sleep((Math.random * 10000).toLong)
	}
}
