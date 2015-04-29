package org.kornel.bloom.hash

object Hsieh extends Hash {

  override def apply(key: Array[Byte]): Int = {
    var hash: Int = 0

    if (key.isEmpty)
      return 0

    for (i <- 0 until key.length / 4) {
      val b0 = key(i * 4)
      val b1 = key(i * 4 + 1)
      val b2 = key(i * 4 + 2)
      val b3 = key(i * 4 + 3)
      val s0 = (b1 << 8) | b0
      val s1 = (b3 << 8) | b2

      hash += s0
      val tmp = (s1 << 11) ^ hash
      hash = (hash << 16) ^ tmp
      hash += hash >>> 11
    }

    val rem = key.length % 4
    val offset = key.length - rem
    rem match {
      case 3 =>
        val b0 = key(offset)
        val b1 = key(offset + 1)
        val b2 = key(offset + 2)
        val s0 = b1 << 8 | b0
        hash += s0
        hash ^= hash << 16
        hash ^= b2 << 18
        hash += hash >>> 11
      case 2 =>
        val b0 = key(offset)
        val b1 = key(offset + 1)
        val s0 = b1 << 8 | b0
        hash += s0
        hash ^= hash << 11
        hash += hash >>> 17
      case 1 =>
        val b0 = key(offset)
        hash += b0
        hash ^= hash << 10
        hash += hash >>> 1
      case 0 => ()
    }

    hash ^= hash << 3
    hash += hash >>> 5
    hash ^= hash << 4
    hash += hash >>> 17
    hash ^= hash << 25
    hash += hash >>> 6

    hash
  }

}
