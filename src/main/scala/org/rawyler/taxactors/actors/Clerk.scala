package org.rawyler.taxactors.actors

import scala.actors._
import models.TaxReturn
import models.TaxInvoice

class Clerk extends Actor {
  
  def act () {
    react {
      case (taxReturn: TaxReturn, actor: Actor) =>
        Thread.sleep((Math.random * 3000).toLong)
        
        val result = new TaxInvoice(taxReturn.income * 0.15)
        
        actor ! result
    }
  }
  
  start
}
