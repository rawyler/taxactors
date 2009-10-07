package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import models.TaxInvoice
import TaxAdministration._

class Clerk extends CalculatingTaxes {
  override val factor = 0.15
  
  override val sleepTime = 3000
}
