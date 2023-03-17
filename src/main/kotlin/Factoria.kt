import Formaciones.*
import kotlin.random.Random

private fun factoriaNumero():Int{
    var numero=Random.nextInt(1,21)
    return numero
}

private fun factoriaNombeLegatus():String{
    var nom = arrayOf("Maximo Mario","Aliciorum Magna","Miriam Décima","Lucio Jaimorum" +
            "Escipión Alejandrus","Pompeya Isabelae","Khattari Optimus","Fernandux Sexto")

    var nombre : String = nom[Random.nextInt(0,nom.size-1)]
    return nombre
}


private fun factoriaNombreTribuno():String{
    var nom = arrayOf("Cayo magnus","Escipion Magna","Maximo decimo","Augusto meridio" +
            "Alejandro magno","Kratos ","Optimus","Trajano")

    var nombre : String = nom[Random.nextInt(0,nom.size-1)]
    return nombre
}

private fun factoriaNombreTribuno2():String{
    var nom = arrayOf("Cayo magnus","Escipion Magna","Maximo decimo","Augusto meridio" +
            "Alejandro magno","Kratos ","Optimus","Trajano")

    var nombre : String = nom[Random.nextInt(0,nom.size-1)]
    return nombre
}


private fun numHombres():Int{
    var num = Random.nextInt(50,200)

    return num
}

public fun factoriaTriari(): Triari {
    var tri = Triari(numHombres(),50)
    return tri
}

public fun factoriaVelite(): Velite {
    var vel = Velite(numHombres(),Random.nextInt(50,100))
    return vel
}

public fun factoriaEquite(): Equite {
    var eq = Equite(numHombres(),Random.nextInt(50,100))
    return eq
}
public fun factoriaAuxiliar(): Auxilia {
    var au = Auxilia(numHombres())
    return au
}

public fun factoriaLegion(nombre: String): Legion {
    var leg = Legion(nombre,13, Oficial(factoriaNombeLegatus()), Oficial(factoriaNombreTribuno()), Oficial(factoriaNombreTribuno2()))
    var azar = Random.nextInt(5)
    for (i in 0..azar){
        var tipoTropa = Random.nextInt(0,4)
        when(tipoTropa){
            0 -> {
                leg.addTropa(factoriaTriari())
            }
            1 -> {
                leg.addTropa(factoriaAuxiliar())
            }
            2 -> {
                leg.addTropa(factoriaEquite())
            }
            3 -> {
                leg.addTropa(factoriaVelite())
            }
        }
    }
    return leg
}
