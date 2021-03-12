package com.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence._

import scala.beans.BeanProperty
/**
 * @author Greg Adler
 */
@Entity
@Table(name = "listings")
case class Listing(
                   idC: Long,
                   @BeanProperty
                   street: String,
                   @BeanProperty
                   status: String,
                   @BeanProperty
                   price: Long,
                   @BeanProperty
                   bedrooms: Int,
                   @BeanProperty
                   bathrooms: Int,
                   @BeanProperty
                   sq_ft: Int,
                   @BeanProperty
                   lat: Double,
                   @BeanProperty
                   lng: Double) {
 


  @Id
  @BeanProperty
  var id: Long = idC
  def this() = this(0,null, null, 0, 0, 0, 0, 0, 0)

}
