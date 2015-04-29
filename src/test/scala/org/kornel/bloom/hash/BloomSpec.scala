package org.kornel.bloom.hash

import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class BloomSpec extends Specification with ScalaCheck {

  "Bloom filter" should {
    "find previously set value" in {
      // given
      val bloom = Bloom(filterSize = 10)

      // when & then
      prop { value: String =>
        bloom.add(value)
        bloom.test(value) must beTrue
      }
    }

    "not find any value in an empty filter" in {
      // given
      val bloom = Bloom(filterSize = 10)

      // when & then
      prop { value: String =>
        bloom.test(value) must beFalse
      }
    }
  }
}
