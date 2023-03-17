package Formaciones

class Triari : Tropa {
    private var edadMaxima : Int

    constructor(
        numHombres: Int,
        edadMaxima: Int
    ) : super(numHombres) {
        this.edadMaxima = edadMaxima
    }

    constructor(){
        this.edadMaxima=0
    }

    fun getEdadMaxima():Int{
        return this.edadMaxima
    }
    fun setEdadMaxima(n:Int){
        this.edadMaxima=n
    }

    override fun diezmar(): String {
        this.setNumHombres((this.getNumHombres() * 0.9).toInt())
        this.recalculaOficialesTropa()
        return "Triari diezmados (${this.getNumHombres()})"
    }


    override fun toString(): String {
        return "${super.toString()} edad Maxima ${edadMaxima}"
    }
}