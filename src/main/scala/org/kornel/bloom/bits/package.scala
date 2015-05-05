package org.kornel.bloom

package object bits {

  private val LowerMask = (1 << 16) - 1

  private val LowerMaskLong = (1L << 32) - 1

  def lower(n: Int): Int = n & LowerMask

  def upper(n: Int): Int = n >> 16

  def lower(n: Long): Long = n & LowerMaskLong

  def upper(n: Long): Long = n >> 32

}
