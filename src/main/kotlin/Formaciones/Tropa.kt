package Formaciones

abstract class Tropa {

    private var numHombres : Int
    private var numCenturion : Int = 0
    private var numDecurion : Int = 0

    constructor(){
        this.numHombres = 0
    }

    constructor(numHombres: Int) {
        this.numHombres = numHombres
        this.recalculaOficialesTropa()
    }


    fun getNumHombres():Int{
        return this.numHombres
    }

    fun setNumHombres(n:Int){
        this.numHombres=n
    }

    fun getNumCenturion():Int{
        return this.numCenturion
    }



    fun getNumDecurion():Int{
        return this.numDecurion
    }

    fun recalculaOficialesTropa(){
        this.numCenturion = this.numHombres / 100
        this.numDecurion = this.numHombres / 10
        if (this.numCenturion == 0){
            this.numCenturion = 1
        }
        if (this.numDecurion == 0){
            this.numDecurion = 1
        }
    }

    abstract fun diezmar() : String

    override fun toString(): String {
        return "Formaciones.Tropa(numHombres=$numHombres, numCenturion=$numCenturion, numDecurion=$numDecurion)"
    }


}