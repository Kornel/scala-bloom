package org.kornel.bloom.hash

trait Hash {

  def apply(bytes: Array[Byte]): Int

  final def apply(anyRef: AnyRef): Int = apply(anyRef2Bytes(anyRef))

}
