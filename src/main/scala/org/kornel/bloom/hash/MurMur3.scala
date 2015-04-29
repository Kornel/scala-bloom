package org.kornel.bloom.hash

object MurMur3 extends Hash {

  override def apply(bytes: Array[Byte]): Int = scala.util.hashing.MurmurHash3.bytesHash(bytes)

}
