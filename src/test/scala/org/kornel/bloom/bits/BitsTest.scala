package org.kornel.bloom.bits

import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class BitsTest extends Specification with ScalaCheck {

  "integer upper/lower" should {

    "return upper and lower int from 0" in {
      // given
      val n = 0

      // when
      val upperNum = upper(n)
      val lowerNum = lower(n)

      // then
      upperNum must be equalTo 0
      lowerNum must be equalTo 0
    }

    "return upper and lower int from MaxValue" in {
      // given
      val n = Int.MaxValue

      // when
      val upperNum = upper(n)
      val lowerNum = lower(n)

      // then
      upperNum must be equalTo ((1 << 15) - 1)
      lowerNum must be equalTo ((1 << 16) - 1)
    }

    "return upper and lower int from 2^16" in {
      // given
      val n = 1 << 16

      // when
      val upperNum = upper(n)
      val lowerNum = lower(n)

      // then
      upperNum must be equalTo 1
      lowerNum must be equalTo 0
    }

    "return upper and lower int" in {
      // given
      val s = "0101010101010101"
      val n = Integer.parseInt(s + s, 2)

      // when
      val upperNum = upper(n)
      val lowerNum = lower(n)

      // then
      upperNum must be equalTo Integer.parseInt(s, 2)
      lowerNum must be equalTo Integer.parseInt(s, 2)
    }

    "return number below 1^16" in {
      prop {
        n: Int =>
          upper(n) must be_<=(1 << 16)
          lower(n) must be_<=(1 << 16)
      }
    }

  }

  "long upper/lower" should {

    "return upper and lower int from 0" in {
      // given
      val n = 0L

      // when
      val upperNum = upper(n)
      val lowerNum = lower(n)

      // then
      upperNum must be equalTo 0
      lowerNum must be equalTo 0
    }

    "return upper and lower int from MaxValue" in {
      // given
      val n = Long.MaxValue

      // when
      val upperNum = upper(n)
      val lowerNum = lower(n)

      // then
      upperNum must be equalTo ((1L << 31) - 1)
      lowerNum must be equalTo ((1L << 32) - 1)
    }

    "return upper and lower int from 2^32" in {
      // given
      val n = 1L << 32

      // when
      val upperNum = upper(n)
      val lowerNum = lower(n)

      // then
      upperNum must be equalTo 1
      lowerNum must be equalTo 0
    }

    "return upper and lower long" in {
      // given
      val s = "01010101010101010101010101010101"
      val n = java.lang.Long.parseLong(s + s, 2)

      // when
      val upperNum = upper(n)
      val lowerNum = lower(n)

      // then
      upperNum must be equalTo java.lang.Long.parseLong(s, 2)
      lowerNum must be equalTo java.lang.Long.parseLong(s, 2)
    }

    "return number below 1^32" in {
      prop {
        n: Long =>
          upper(n) must be_<=(1L << 32)
          lower(n) must be_<=(1L << 32)
      }
    }

  }
}
