package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import models.TaxInvoice

class Citizen(val name: String, val salary: Double) extends Actor with TaxPayer {
  require(name != "")
  
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
          
          exit()
      }
    }
    
  }
  
  override def toString = name
  
  override def equals(other: Any): Boolean = 
    other match {
      
      case that: Citizen =>
        (that canEqual this) &&
        name == that.name &&
        salary == that.salary
        
      case _ => false
    }
  
  def canEqual(other: Any): Boolean =
    other.isInstanceOf[Citizen]
  
  override def hashCode: Int =
    41 * (
      41 + name.hashCode
    ) + salary.hashCode
  
  start()
}
