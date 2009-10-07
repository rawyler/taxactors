package org.rawyler.taxactors.models

import actors.Citizen
import actors.TaxAdministration

object City {
  
  val BaseSalary = 40000
  
  val PlusSalary = 60000
  
  val Population = 10
  
  def citizens(): Seq[Citizen] =
    for {
      i <- (1 to Population)
    } yield new Citizen(i.toString, (Math.random * PlusSalary + BaseSalary).ceil)
  
  def main(args: Array[String]) {
    val citizensArray = citizens.toArray
    
    TaxAdministration ! citizensArray
  }
}
