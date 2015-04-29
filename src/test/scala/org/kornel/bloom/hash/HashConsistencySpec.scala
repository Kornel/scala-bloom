package org.kornel.bloom.hash

import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class HashConsistencySpec extends Specification with ScalaCheck {

  val algorithms = Seq(MurMur3, FNV, Hsieh)

  algorithms.foreach { algo =>
    s"Hashing fuction $algo" should {
      "be consistent for byte arrays" in {
        prop {
          bytes: Array[Byte] => algo(bytes) must_== algo(bytes)
        }
      }

      "be consistent for any String" in {
        prop {
          ref: String => algo(ref) must_== algo(ref)
        }
      }
    }
  }

}
