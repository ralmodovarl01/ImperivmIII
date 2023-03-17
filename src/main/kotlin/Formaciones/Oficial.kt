package Formaciones

class Oficial {
    private var nombre : String = ""

    constructor(nombre: String) {
        this.nombre = nombre
    }


    fun getNombre() = this.nombre
    fun setNombre(n : String){
        this.nombre = n
    }

    override fun toString(): String {
        return "Formaciones.Oficial(nombre='$nombre')"
    }


}