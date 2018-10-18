package es.smartech.domain.Model

import java.io.Serializable

interface Mapeable : Serializable{
    fun get_Name(): String
    fun get_Description() : String
    fun get_Latitude(): Float
    fun get_Longitude(): Float
    fun get_Image(): String
}