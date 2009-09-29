package org.rawyler.taxactors.actors

import scala.actors._
import model.TaxReturn
import model.TaxInvoice

class Citizen(name: String, salary: Double) extends Actor with TaxPayer {
  
  def act() {
    
    react {
      case (taxReturn: TaxReturn, actor: Actor) =>
	    // this will take a while
	    doTaxes
        taxReturn.income = salary
        
        taxReturn.sign
        
        actor ! (taxReturn, this)
        
        act()
        
      case (taxInvoice: TaxInvoice, actor: Actor) =>
        // ouch
        taxInvoice.pay
        
        actor ! (taxInvoice, this)
        
        // quit
    }
    
  }
}
