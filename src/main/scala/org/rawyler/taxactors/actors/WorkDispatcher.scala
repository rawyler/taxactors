package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn

object WorkDispatcher extends Actor {
  def act() {
    loop {
      react {
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
    
    // TODO: random list access
    list.head
  }
  
  start
}
