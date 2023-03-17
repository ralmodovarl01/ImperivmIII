package Formaciones

class Auxilia : Tropa {

    constructor(
        numHombres: Int,
    ) : super(numHombres)

    override fun diezmar() :String {
        return "Vergonzorum me daria"
    }


    override fun toString(): String {
        return "${super.toString()}"
    }


}