package org.rawyler.taxactors.model

trait Payable {
  var payed = false
  
  def pay () {
    payed = true
  }
}
