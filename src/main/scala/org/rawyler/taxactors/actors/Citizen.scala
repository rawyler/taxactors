package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import models.TaxInvoice

class Citizen(val name: String, val salary: Double) extends Actor with TaxPayer {
  
  def act() {
    
    loop {
      react {
        case (taxReturn: TaxReturn, administration: Actor) =>
	      println(this + " started")
        
	      doTaxes
     
          taxReturn.income = salary
        
          taxReturn.sign
        
          // println (name + " got " + taxReturn)
        
          administration ! (taxReturn, this)
        
        case (taxInvoice: TaxInvoice, administration: Actor) =>
          // ouch
          taxInvoice.pay
          
          println(this + " payed my taxes")
        
          administration ! (taxInvoice, this)
      }
    }
    
  }
  
  override def toString = name
  
  start
}
