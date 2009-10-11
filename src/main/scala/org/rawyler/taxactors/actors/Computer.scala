package org.rawyler.taxactors.actors

import scala.actors._
import scala.actors.Actor._
import models.TaxReturn
import models.TaxInvoice
import TaxAdministration._

class Computer extends CalculatingTaxes
