package org.kornel.bloom.hash

object FNV extends Hash {

  private val MaxUnsignedInt = 0xFFFFFFFFL

  private val Prime = 16777619

  override def apply(key: Array[Byte]): Int = {
    var i = 0
    val len = key.length
    var rv: Long = 0x811c9dc5L
    while (i < len) {
      rv = (rv * Prime) ^ (key(i) & 0xff)
      i += 1
    }
    (rv & MaxUnsignedInt).toInt
  }

}
