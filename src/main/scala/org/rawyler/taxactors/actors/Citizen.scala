package org.rawyler.taxactors.actors

import scala.actors._
import models.TaxReturn
import models.TaxInvoice

class Citizen(name: String, salary: Double) extends Actor with TaxPayer {
  
  def act() {
    
    react {
      case (taxReturn: TaxReturn, actor: Actor) =>
	    println(name + " started")
        
	    doTaxes
     
        taxReturn.income = salary
        
        taxReturn.sign
        
        println (name + " got " + taxReturn)
        
        actor ! (taxReturn, this)
        
        act()
        
      case (taxInvoice: TaxInvoice, actor: Actor) =>
        // ouch
        taxInvoice.pay
        
        actor ! (taxInvoice, this)
        
        // quit
      case msg =>
        println("no match with " + msg)
    }
    
  }
}
