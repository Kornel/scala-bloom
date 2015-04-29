package org.kornel.bloom.hash

object FNV {

  private val MaxUnsignedInt = 0xFFFFFFFFL

  private val Prime = 16777619

  def apply(key: Array[Byte]): Int = {
    var i = 0
    val len = key.length
    var rv: Long = 0x811c9dc5L
    while (i < len) {
      rv = (rv * Prime) ^ (key(i) & 0xff)
      i += 1
    }
    (rv & MaxUnsignedInt).toInt
  }

  def apply(any: AnyRef): Int = apply(anyRef2Bytes(any))

}
