package org.rawyler.taxactors.models

trait Payable {
  var payed = false
  
  def pay () {
    payed = true
  }
}
