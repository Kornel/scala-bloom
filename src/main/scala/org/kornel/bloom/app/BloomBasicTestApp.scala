package org.kornel.bloom.app

import org.kornel.bloom.filter.BloomBasic
import org.kornel.bloom.hash.Hash

object BloomBasicTestApp extends App {

  val filterSize = Seq(1000, 20000, 80000, 200000)
  val elementsToAdd = Seq(1000, 10000, 50000)

  val allWords = AllWords()

  val results = filterSize.flatMap { fs =>

    elementsToAdd.map { count =>

      val filter = BloomBasic(fs)

      (0 until count).foreach { c =>
        filter.addIfNotPresent(allWords(c))
      }

      Result(fs, count, filter.distinctCount)
    }
  }

  results.foreach(println)

  case class Result(filterSize: Int, expectedDistinctCount: Int, actualDistinctCount: Int) {
    override def toString: String = s"$filterSize\t$expectedDistinctCount\t$actualDistinctCount\t${expectedDistinctCount - actualDistinctCount}"
  }

}
