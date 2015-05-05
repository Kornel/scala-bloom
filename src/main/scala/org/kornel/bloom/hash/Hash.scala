package org.kornel.bloom.hash

trait Hash[N] {

  def apply(bytes: Array[Byte]): N

  final def apply(anyRef: AnyRef): N = apply(anyRef2Bytes(anyRef))

}
