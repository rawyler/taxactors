package org.rawyler.taxactors.models

import actors.Citizen

trait Signable {
  var signed = false
  
  def sign() = {
    signed = true
  }
}
