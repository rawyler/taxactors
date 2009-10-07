package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import TaxAdministration._

object WorkDispatcher extends Actor {
  def act() {
    loop {
      react {
        case Stop =>
          exit()
          
        case (taxReturn: TaxReturn, administration: Actor) =>
          pickRandomOfPool ! (taxReturn, administration)
          
        case anything: Any =>
          pickRandomOfPool ! anything

      }
    }
  }
  
  def pickRandomOfPool: Actor = {
    val list = if(Math.random < 0.2) {
        TaxAdministration.clerks
      } else {
        TaxAdministration.computers
      }
    
    list((Math.random * list.size).toInt)
  }
  
  start()
}
