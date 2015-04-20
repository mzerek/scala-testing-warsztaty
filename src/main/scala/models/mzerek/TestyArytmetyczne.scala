package models.mzerek

import org.scalacheck.Properties
import org.scalacheck.Prop._
import Math._
import org.scalacheck.Gen

object TestyArytmetyczne extends Properties("Matematyka") {

  val intForPair = Gen.choose(0, Int.MaxValue / 2)

  val smallpositivePair = for {
    a <- intForPair
    b <- intForPair
  } yield (a, b)

  property("a+b>a") = forAll(smallpositivePair) {
    case (a, b) =>
      println(s"a=${a},b=${b}")
      a + b > a
  }

}