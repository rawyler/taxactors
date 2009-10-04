package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import models.TaxInvoice

object TaxAdministration extends Actor{
  val clerks: List[Clerk] = for (i <- (1 to 10).toList)
    yield new Clerk()
  
  val computers: List[Computer] = for (i <- (1 to 5).toList)
    yield new Computer()
  
  var simpleCheckSum = 0

  def act(){
    loop {
      react {
        case citizens: Array[Citizen] =>
          println("processing " + citizens.size + " citizens")
          simpleCheckSum = citizens.size
          citizens.foreach(c => c ! (new TaxReturn(c, null), this))
        
        case (taxReturn: TaxReturn, citizen: Actor) =>
          WorkDispatcher ! (taxReturn, this)
          
        case taxReturn: TaxReturn =>
          taxReturn.citizen ! (taxReturn.taxInvoice, this)
          
        case (taxInvoice: TaxInvoice, citizen: Citizen) =>
          if(taxInvoice.payed) simpleCheckSum -= 1
        
      }
    }
    
  }
  
  start
}
