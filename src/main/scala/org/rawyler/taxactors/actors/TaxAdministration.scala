package org.rawyler.taxactors.actors

import scala.actors._
import models.TaxReturn

object TaxAdministration extends Actor{
  val clerks: List[Clerk] = for (i <- (1 to 10).toList)
    yield new Clerk()
  
  val computers: List[Computer] = for (i <- (1 to 10).toList)
    yield new Computer()

  def act(){
    
    react {
      case citizens: Array[Citizen] =>
        println("starting clerks and computers...")
        clerks.foreach(_.start)
        println("processing " + citizens.size + " citizens")
        
        citizens.foreach(c => c ! (new TaxReturn(c, null), this))
        
    }
    
  }
}
