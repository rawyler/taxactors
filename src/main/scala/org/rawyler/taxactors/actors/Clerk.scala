package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import models.TaxInvoice

class Clerk extends Actor {
  
  def act () {
    loop {
      react {
        case (taxReturn: TaxReturn, administration: Actor) =>
          Thread.sleep((Math.random * 3000).toLong)
          
          taxReturn.taxInvoice = new TaxInvoice(taxReturn.income * 0.15)
        
          administration ! taxReturn
      }
    }
  }
  
  start
}
