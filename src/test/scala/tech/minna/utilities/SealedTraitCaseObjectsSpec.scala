package tech.minna.utilities

import org.scalatest.{FlatSpec, Matchers}

class SealedTraitCaseObjectsSpec extends FlatSpec with Matchers {
  sealed trait Vehicle extends Product with Serializable

  object Vehicle {
    case object Bus extends Vehicle
    case object Car extends Vehicle
    case object MiniVan extends Vehicle

    val all = SealedTraitCaseObjects.values[Vehicle]
  }

  "SealedTraitCaseObjects.values" should "list all the case objects inherited from the sealed trait" in {
    import Vehicle._
    Vehicle.all shouldEqual Set(Bus, Car, MiniVan)
  }
}
