package org.kornel.bloom.hash

case class Bloom(filterSize: Int, hashFunctions: Seq[Hash] = Seq(FNV, MurMur3, Hsieh)) {

  private val buckets = new Array[Byte](filterSize)

  def add(anyRef: AnyRef): Unit = hashIndices(anyRef).foreach(i => buckets(i) = 1)

  def test(anyRef: AnyRef): Boolean = {
    hashIndices(anyRef).forall(n => buckets(n) == 1)
  }

  private def hashIndices(anyRef: AnyRef): Seq[Int] = hashFunctions
    .map(_.apply(anyRef) % filterSize)
    .map(math.abs)

}
