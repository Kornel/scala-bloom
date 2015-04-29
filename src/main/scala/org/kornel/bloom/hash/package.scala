package org.kornel.bloom

import java.io.{ObjectOutputStream, ByteArrayOutputStream}

package object hash {

  def anyRef2Bytes(any: AnyRef): Array[Byte] = {
    val b = new ByteArrayOutputStream()
    val os = new ObjectOutputStream(b)
    os.writeObject(any)
    b.toByteArray
  }

}
