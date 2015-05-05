package org.kornel.bloom.app

import java.io.FileWriter

import org.kornel.bloom.hash.n32.{FNV, MultiHash}
import org.kornel.bloom.hash.Hash

object HashDistributionApp extends App {

  val max = 10000

  val allWords = AllWords()

  val base = FNV
  probe(base, "mm3")
  probe(MultiHash(base, 0), "multi-mm3-0")
  probe(MultiHash(base, 1), "multi-mm3-1")
  probe(MultiHash(base, 5), "multi-mm3-5")
  probe(MultiHash(base, 10), "multi-mm3-10")

  private def probe[N](hashFunc: Hash[N], name: String): Unit = {
    val fileName = s"/tmp/hashes-words-$name.csv"

    println(s"$fileName")

    val tw = new FileWriter(fileName)
    tw.write("hash,word\n")

    (0 until max).foreach {
      n =>
        val idx = (math.random * allWords.length).toInt
        val word = allWords(idx)
        val hash = hashFunc(word)
        tw.write(s"$hash,$word\n")
    }

    tw.close()
  }

}
