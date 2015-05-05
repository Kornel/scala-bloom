package org.kornel.bloom.filter

object BloomFilter {

  def optimalFilterSize(items: Int, expectedFalsePositiveRate: Double): Int = {
    math.ceil(items / (math.log(0.5) * math.log(0.5) / math.abs(math.log(expectedFalsePositiveRate)))).toInt
  }

  def optimalHashFunctions(expectedFalsePositivesRate: Double): Int = {
    math.ceil(log2(1 / expectedFalsePositivesRate)).toInt
  }

  private def log2(n: Double) = math.log(n) / math.log(2)
}

object Test extends App {
  println(BloomFilter.optimalHashFunctions(0.1))
  println(BloomFilter.optimalFilterSize(50000, 0.5))
}