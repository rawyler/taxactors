package org.rawyler.taxactors.actors

import scala.actors._
import models.TaxReturn
import models.TaxInvoice

class Computer extends Actor {
  
  def act () {
    react {
      case (taxReturn: TaxReturn, administration: Actor) =>
        taxReturn.taxInvoice = new TaxInvoice(taxReturn.income * 0.1)
        
        administration ! taxReturn
    }
  }
  
  start
}
