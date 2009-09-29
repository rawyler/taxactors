package org.rawyler.taxactors.actors

import scala.actors._
import model.TaxReturn
import model.TaxInvoice

class Clerk extends Actor {
  
  def act () {
    react {
      case (taxReturn: TaxReturn, actor: Actor) =>
        val result = new TaxInvoice(taxReturn.income * 0.15)
        
        actor ! result
    }
  }
}
