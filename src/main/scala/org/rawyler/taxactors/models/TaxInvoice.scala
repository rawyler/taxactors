package org.rawyler.taxactors.models

import actors.Citizen

class TaxInvoice(amount: Double) extends Payable {
  override def toString = amount.toString
}
