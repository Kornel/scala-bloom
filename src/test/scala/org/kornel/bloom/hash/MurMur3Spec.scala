package org.kornel.bloom.hash

import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class MurMur3Spec extends Specification with ScalaCheck {

  "MurMur3" should {
    "be consistent for byte arrays" in {
      prop {
        bytes: Array[Byte] => MurMur3(bytes) must_== MurMur3(bytes)
      }
    }

    "be consistent for any String" in {
      prop {
        ref: String => MurMur3(ref) must_== MurMur3(ref)
      }
    }
  }

}
