package org.rawyler.taxactors.actors

import scala.actors._

case class PassCitizens(citizens: List[Citizen])

object TaxAdministration extends Actor{
  def act(){
    react {
      case PassCitizens(citizens) =>
        citizens
        
    }
  }
}
