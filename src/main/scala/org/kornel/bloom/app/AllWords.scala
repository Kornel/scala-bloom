package org.kornel.bloom.app

object AllWords {

  def apply() = {
    val source = io.Source.fromInputStream(getClass.getResourceAsStream("/corncob_lowercase.txt"))
    val list = source.getLines().toVector
    source.close()
    list
  }
}
