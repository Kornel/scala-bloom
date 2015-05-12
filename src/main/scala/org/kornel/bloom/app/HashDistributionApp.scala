package org.kornel.bloom.app

import java.io.FileWriter

import org.kornel.bloom.hash.n32.{MurMur3, FNV, MultiHash}
import org.kornel.bloom.hash.Hash

object HashDistributionApp extends App {

  val allWords = AllWords()

  //val max = math.min(10000, allWords.length)
  val max = allWords.length

  println(s"Working on $max elements...")

  val base = FNV

  probe(MurMur3, "mm3")
  probe(base, "fnv")
  probe(MultiHash(base, 0), "multi-fnv-0")
  probe(MultiHash(base, 1), "multi-fnv-1")
  probe(MultiHash(base, 5), "multi-fnv-5")
  probe(MultiHash(base, 10), "multi-fnv-10")

  private def probe[N](hashFunc: Hash[N], name: String): Unit = {

    //val randomNumber = scala.util.Random.shuffle((0 until allWords.length).toList).toIterator

    val fileName = s"/tmp/hashes-words-$name.csv"

    println(s"$fileName")

    val tw = new FileWriter(fileName)
    tw.write("hash,word\n")

    val hashes = scala.collection.mutable.Set[N]()

    (0 until max).foreach {
      n =>
        val idx = n //randomNumber.next
        val word = allWords(idx)
        val hash = hashFunc(word)

        hashes += hash

        tw.write(s"$hash,$word\n")
    }

    val collisions = max - hashes.size

    println(s"Collisions: $collisions")

    tw.close()
  }

}
