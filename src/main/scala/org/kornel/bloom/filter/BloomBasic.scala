package org.kornel.bloom.filter

import org.kornel.bloom.hash.n32.{Hsieh, MurMur3, FNV}
import org.kornel.bloom.hash.Hash

case class BloomBasic(filterSize: Int, hashFunctions: Seq[Hash[Int]] = Seq(FNV, MurMur3, Hsieh)) {

  private val buckets = new Array[Byte](filterSize)

  private var _distinctCount = 0

  def distinctCount = _distinctCount

  private[filter] def add(anyRef: AnyRef): Unit = hashIndices(anyRef).foreach(i => buckets(i) = 1)

  def addIfNotPresent(anyRef: AnyRef): Unit = {
    if (!contains(anyRef)) {
      add(anyRef)
      _distinctCount += 1
    }
  }
  
  def contains(anyRef: AnyRef): Boolean = {
    hashIndices(anyRef).forall(n => buckets(n) == 1)
  }

  private def hashIndices(anyRef: AnyRef): Seq[Int] = hashFunctions
    .map(_.apply(anyRef) % filterSize)
    .map(math.abs)

}
