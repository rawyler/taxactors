package org.rawyler.taxactors.models

import actors.Citizen

class TaxReturn(var citizen: Citizen, var taxInvoice: TaxInvoice) extends Signable {
  var income : Double = 0
  
  override def toString = {
    income.toString + " " + signed.toString + " " + taxInvoice
  }
}
