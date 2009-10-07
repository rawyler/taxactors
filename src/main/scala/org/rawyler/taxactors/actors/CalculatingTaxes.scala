package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import models.TaxInvoice
import TaxAdministration._

trait CalculatingTaxes extends Actor {
  val factor = 0.1
  
  def act () {
    loop {
      react {
        case (taxReturn: TaxReturn, administration: Actor) =>
          Thread.sleep((Math.random * 3000).toLong)
          
          taxReturn.taxInvoice = new TaxInvoice(taxReturn.income * factor)
        
          administration ! taxReturn
          
        case Stop =>
          exit()
      }
    }
  }
  
  start()
}
