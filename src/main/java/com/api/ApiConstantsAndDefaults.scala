package com.api

import scala.reflect.api

/**
 * @author Greg Adler
 */
trait ApiConstantsAndDefaults {
  final val LISTINGS="/listings"
  final val MIN_PRICE="0"
  final val MAX_PRICE="999999999"
  final val MIN_BED="0"
  final val MAX_BED="100"
  final val MIN_BATH="0"
  final val MAX_BATH="100"
  final val PAGE="0"
  final val PAGE_SIZE = "50"
}

object ApiConstantsAndDefaults extends ApiConstantsAndDefaults