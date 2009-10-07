package org.rawyler.taxactors.models

import actors.Citizen
import actors.TaxAdministration

object City {
  
  def citizens(): Seq[Citizen] =
    for {
      i <- (1 to 10)
    } yield new Citizen(i.toString, (Math.random * 60000 + 40000).ceil)
  
  def main(args: Array[String]) {
    val citizensArray = citizens.toArray
    
    TaxAdministration ! citizensArray
  }
}
