package Formaciones

class Velite : Tropa {

    private var animo : Int

    constructor(){
        this.animo=0
    }

    constructor(
        numHombres: Int,
        animo: Int
    ) : super( numHombres) {
        this.animo = animo
    }



    fun getAnimo():Int{
        return this.animo
    }

    fun setAnimo(a:Int){
        this.animo=a
    }

    override fun diezmar(): String {
        return "Un poquitus de por favorum; próxima vex"
    }


    override fun toString(): String {
        return "${super.toString()} animo${animo}"
    }
}