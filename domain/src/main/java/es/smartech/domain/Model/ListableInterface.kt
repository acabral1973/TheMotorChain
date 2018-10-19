package es.smartech.domain.Model

import java.io.Serializable

interface Listable: Serializable {
    fun get_Image(): String
    fun getTitle(): String
    fun getSubtitle(): String
}