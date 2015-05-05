package org.kornel.bloom.hash.n32

import org.kornel.bloom.bits._
import org.kornel.bloom.hash.Hash

case class MultiHash(base: Hash[Int], n: Int) extends Hash[Int] {

  private val M = n * n

  override def apply(bytes: Array[Byte]): Int = {
    val hash = base.apply(bytes)

    lower(hash) + n * upper(hash) + M
  }

}
