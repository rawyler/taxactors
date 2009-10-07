package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import models.TaxInvoice
import scala.collection.mutable.Map

object TaxAdministration extends Actor {
  case object Stop
  
  val clerks: List[Clerk] = for (i <- (1 to 10).toList)
    yield new Clerk()
  
  val computers: List[Computer] = for (i <- (1 to 5).toList)
    yield new Computer()
  
  private val citizenCache = Map.empty[String, Citizen]
  
  def act(){
    loop {
      react {
        case citizens: Array[Citizen] =>
          println("processing " + citizens.size + " citizens")
          
          citizenCache ++ (for {
            c <- citizens
          } yield (c.name -> c))
          
          citizens.foreach(c => c ! (new TaxReturn(c, null), this))
        
        case (taxReturn: TaxReturn, citizen: Actor) =>
          WorkDispatcher ! (taxReturn, this)
          
        case taxReturn: TaxReturn =>
          taxReturn.citizen ! (taxReturn.taxInvoice, this)
          
        case (taxInvoice: TaxInvoice, citizen: Citizen) =>
          
          if(taxInvoice.payed) citizenCache - (citizen.name)
          
          if(citizenCache.isEmpty) {
            println("done")
            
            val workers = clerks ::: computers
            workers.foreach(_ ! Stop)
            
            WorkDispatcher ! Stop
            
            exit()
          }
        
      }
    }
    
  }
  
  start()
}
