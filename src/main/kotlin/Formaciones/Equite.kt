package Formaciones

class Equite : Tropa {

    private var caballos : Int

    constructor(
        numHombres: Int,
        caballos: Int
    ) : super(numHombres) {
        this.caballos = caballos
    }
    constructor(){
        this.caballos=0
    }

    fun getCaballos():Int{
        return this.caballos
    }

    fun setCaballos(n:Int){
        this.caballos=n
    }

    override fun diezmar(): String {
        this.setNumHombres((this.getNumHombres() * 0.99).toInt())
        this.recalculaOficialesTropa()
        return "Équites diezmados (${this.getNumHombres()})"
    }


    override fun toString(): String {
        return "${super.toString()} numero de caballos ${caballos}"
    }
}