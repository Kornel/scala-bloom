package org.kornel.bloom.hash.n64

import org.kornel.bloom.hash.Hash

object FNV extends Hash[Long] {

  def apply(key: Array[Byte]): Long = {
    val prime = 1099511628211L
    var i = 0
    val len = key.length
    var rv: Long = 0xcbf29ce484222325L
    while (i < len) {
      rv = (rv * prime) ^ (key(i) & 0xff)
      i += 1
    }
    rv
  }

}
