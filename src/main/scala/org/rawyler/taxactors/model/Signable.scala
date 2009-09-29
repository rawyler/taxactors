package org.rawyler.taxactors.model

trait Signable {
  var signed = false
  
  def sign() {
    signed = true
  }
}
