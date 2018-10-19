package es.smartech.domain.Model

data class Car (val id: Int = 0,
                val make: String = "",
                val model: String = "",
                val year: Int = 0,
                val colour: String = "",
                val image: String = "",
                val owner: String = "",
                val latitude : Float = 0f,
                var longitude : Float = 0f,
                val kilometers: String = "") : Mapeable, Listable {

    // Listable methods

    override fun getTitle(): String {
        return make
    }

    override fun getSubtitle(): String {
        return model + " (" + year.toString() + ")"
    }

    // Mapeable methods

    override fun get_Name(): String {
        return make + " " + model
    }

    override fun get_Description(): String {
        return  "(" + year.toString() + ")"
    }

    override fun get_Latitude(): Float {
        return latitude
    }

    override fun get_Longitude(): Float {
        return longitude
    }

    override fun get_Image(): String {
        return image
    }

}

