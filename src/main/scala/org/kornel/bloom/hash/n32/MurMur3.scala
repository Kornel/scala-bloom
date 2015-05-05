package org.kornel.bloom.hash.n32

import org.kornel.bloom.hash.Hash

object MurMur3 extends Hash[Int] {

  override def apply(bytes: Array[Byte]): Int = scala.util.hashing.MurmurHash3.bytesHash(bytes)

}
