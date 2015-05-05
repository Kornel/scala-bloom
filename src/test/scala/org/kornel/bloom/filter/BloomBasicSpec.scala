package org.kornel.bloom.filter

import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class BloomBasicSpec extends Specification with ScalaCheck {

  "Bloom filter" should {

    "count distinct elements" in {
      prop { value: String =>
        // given
        val bloom = BloomBasic(filterSize = 10)

        // when
        bloom.addIfNotPresent(value)

        // then
        bloom.contains(value) must beTrue
        bloom.distinctCount must_== 1
      }
    }

    "find previously set value" in {
      prop { value: String =>
        // given
        val bloom = BloomBasic(filterSize = 10)

        // when
        bloom.add(value)

        // then
        bloom.contains(value) must beTrue
      }
    }

    "not find any value in an empty filter" in {
      prop { value: String =>
        // given
        val bloom = BloomBasic(filterSize = 10)

        // when & then
        bloom.contains(value) must beFalse
      }
    }
  }
}
