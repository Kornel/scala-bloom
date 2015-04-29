package org.kornel.bloom.hash

import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class FNVSpec extends Specification with ScalaCheck {

  "FNV" should {
    "be consistent for byte arrays" in {
      prop {
        bytes: Array[Byte] => FNV(bytes) must_== FNV(bytes)
      }
    }

    "be consistent for any String" in {
      prop {
        ref: String => FNV(ref) must_== FNV(ref)
      }
    }
  }

}
