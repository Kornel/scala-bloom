package org.kornel.bloom.hash.n64

import org.kornel.bloom.bits.{lower, upper}
import org.kornel.bloom.hash.Hash

case class MultiHash(base: Hash[Long], n: Int) extends Hash[Long] {

  private val M = n * n

  override def apply(bytes: Array[Byte]): Long = {
    val hash = base.apply(bytes)

    lower(hash) + n * upper(hash) + M
  }

}
