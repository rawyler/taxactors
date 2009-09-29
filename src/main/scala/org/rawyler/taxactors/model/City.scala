package org.rawyler.taxactors.model

import actors.Citizen
import actors.TaxAdministration

object City {
  
  def citizens(): List[Citizen] =
    for {
      i <- (1 to 10).toList
    } yield new Citizen(i.toString, Math.random * 60000 + 40000)
  
  def main(args: Array[String]) {
    TaxAdministration.start
    
    TaxAdministration ! citizens
  }
}
