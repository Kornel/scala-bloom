package org.kornel.bloom.hash

object MurMur3 {

  def apply(bytes: Array[Byte]): Int = scala.util.hashing.MurmurHash3.bytesHash(bytes)

  def apply(any: AnyRef): Int = apply(anyRef2Bytes(any))

}
