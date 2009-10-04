package org.rawyler.taxactors.models

import actors.Citizen

class TaxInvoice(val amount: Double) extends Payable {
  override def toString = amount.toString
}
