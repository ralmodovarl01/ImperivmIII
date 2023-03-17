import Formaciones.Legion
import Formaciones.Tropa
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random


fun main(args: Array<String>) {
    var tiempo = 1
    var campoBatalla = Batalla()
    var legionsJC = ArrayList<Legion?>()
    var legionsPO = ArrayList<Legion?>()

    iniciarLegions(legionsJC,"J", 3)
    iniciarLegions(legionsPO,"P", 4)

    println(legionsJC)
    println(legionsPO)

    campoBatalla.iniciarCampo(legionsJC, legionsPO)
    println(campoBatalla)


    while(tiempo <= 60){

        if (tiempo % 3 == 0){//Se mueven las tropas.
            println("Las tropas se mueven")
            for (i in 0..campoBatalla.getCantFilas()-1){
                for (j in 0 .. campoBatalla.getCantCols()-1){
                    if (campoBatalla.getCampo(i,j) is Legion){
                        println("Se mueve la legión ${campoBatalla.getCampo(i,j)}")
                        var movida = false
                        var intentosMover = 1
                        while(!movida && intentosMover < 6){
                            var posMover = eligePosValida(i,j, campoBatalla)
                            if (campoBatalla.getCampo(posMover[0],posMover[1])==null){//Si el lugar elegido está en blanco
                                campoBatalla.setCampo(posMover[0],posMover[1], campoBatalla.getCampo(i, j))  //La tropa se desplaza
                                campoBatalla.setCampo(i, j, null) //Donde estaba se queda a nulo
                                movida = true
                            } else {//Si no es nulo veremos si es una legión o un puente
                                if (campoBatalla.getCampo(posMover[0],posMover[1]) is Legion) { //Comprobamos si es una legión contrincante.
                                    var legionActual = campoBatalla.getCampo(i, j) as Legion
                                    var legionContraria = campoBatalla.getCampo(posMover[0],posMover[1]) as Legion
                                    if (legionActual.getNombre().substring(0,1) != legionContraria.getNombre().substring(0,1)){ //Son legiones contrarias.
                                        println("Las legiones ${legionActual.getNombre()} y ${legionContraria.getNombre()} luchan por la posición ${Arrays.toString(posMover)}")
                                        if (luchanLegions(legionActual, legionContraria) == 1){//Gana la que se movía y por lo tanto ocupa la posición de la otra.
                                            println("Gana la legión ${legionActual.getNombre()}")
                                            campoBatalla.setCampo(posMover[0],posMover[1], campoBatalla.getCampo(i, j))  //La tropa se desplaza y machaca a la que había antes ahí, porque le ha ganado la batalla.
                                            campoBatalla.setCampo(i, j, null) //Donde estaba se queda a nulo
                                        }
                                        else {//Ha perdido la que se desplazaba y por lo tanto esa posición se pone a null.
                                            println("Gana la legión ${legionContraria.getNombre()}")
                                            campoBatalla.setCampo(i, j, null) //Donde estaba se queda a nulo, porque ha perdido.
                                        }
                                        movida = true
                                    }
                                }
                                if (campoBatalla.getCampo(posMover[0],posMover[1]) is String){  //Comprobamos si es un río
                                    var cad = campoBatalla.getCampo(posMover[0],posMover[1]) as String
                                    if (cad.equals("R")){
                                        var posCruce = cruzaRio(i, j)
                                        //El bloque que sigue está copiado y pegado del anterior cambiando posMover por posCruce. Esto es una posible solución. Se podría encapsular en una función.
                                        if (campoBatalla.getCampo(posCruce[0],posCruce[1])==null){//Si el lugar elegido está en blanco
                                            campoBatalla.setCampo(posCruce[0],posCruce[1], campoBatalla.getCampo(i, j))  //La tropa se desplaza
                                            campoBatalla.setCampo(i, j, null) //Donde estaba se queda a nulo
                                            movida = true
                                        }
                                        else {
                                            if (campoBatalla.getCampo(posCruce[0],posCruce[1]) is Legion) {
                                                var legionActual = campoBatalla.getCampo(i, j) as Legion
                                                var legionContraria = campoBatalla.getCampo(posCruce[0],posCruce[1]) as Legion
                                                if (legionActual.getNombre().substring(0,1) != legionContraria.getNombre().substring(0,1)){ //Son legiones contrarias.
                                                    println("Las legiones ${legionActual.getNombre()} y ${legionContraria.getNombre()} luchan por la posición ${Arrays.toString(posCruce)}")
                                                    if (luchanLegions(legionActual, legionContraria) == 1){//Gana la que se movía y por lo tanto ocupa la posición de la otra.
                                                        println("Gana la legión ${legionActual.getNombre()}")
                                                        campoBatalla.setCampo(posCruce[0],posCruce[1], campoBatalla.getCampo(i, j))  //La tropa se desplaza y machaca a la que había antes ahí, porque le ha ganado la batalla.
                                                        campoBatalla.setCampo(i, j, null) //Donde estaba se queda a nulo
                                                    }
                                                    else {//Ha perdido la que se desplazaba y por lo tanto esa posición se pone a null.
                                                        println("Gana la legión ${legionContraria.getNombre()}")
                                                        campoBatalla.setCampo(i, j, null) //Donde estaba se queda a nulo, porque ha perdido.
                                                    }
                                                    movida = true
                                                }

                                            }
                                        }

                                    }
                                }
                            }
                            intentosMover++
                        }
                    }
                }
            }
        }
        if (tiempo % 20 == 0) {
            println("Diezmando")
            for (i in 0..campoBatalla.getCantFilas()-1) {
                for (j in 0..campoBatalla.getCantCols() - 1) {
                    if (campoBatalla.getCampo(i,j) is Legion){
                        var legionActual = campoBatalla.getCampo(i, j) as Legion
                        println("Diezmando la legión ${legionActual.getNombre()}")
                        for (i in 0..legionActual.getCuantsaTropas()-1){
                            println(legionActual.getTropaAt(i).diezmar())
                        }
                    }
                }
            }
        }

        tiempo++
        Thread.sleep(1000)
        println(campoBatalla)
        println("------------------- ${tiempo} ------------------------")
    }

    println("**************************************")
    println("***** Resultado de la batalla ********")
    println("**************************************")

    var cuantasJC = campoBatalla.cuantasJulioCesar()
    var cuantasPO = campoBatalla.cuantasPompeyo()
    println("Julio César conserva ${cuantasJC}")
    println("Pompeyo conserva ${cuantasPO}")
    if (cuantasJC > cuantasPO){
        println("Gana Cayo Julio César")
    }
    if (cuantasJC < cuantasPO){
        println("Gana Cneo Pompeyo Magno")
    }
    if (cuantasJC == cuantasPO){
        println("Empate")
    }
}


//********************************* Funciones auxiliares ************************************************

fun cruzaRio(i:Int, j:Int): Array<Int> {
    var cruce = arrayOf(0,0)
    cruce[0] = i
    if (j == 0){ //La legión está en la orilla izquierda y pasa a la derecha.
        cruce[1] = 2
    }
    else {//La legión está en la derecha y pasa a la izquierda.
        cruce[1] = 0
    }
    return cruce
}

fun luchanLegions(legionActual: Legion, legionContraria: Legion): Int {
    var gana = 2
    if (legionActual.cantTropas() >= legionContraria.cantTropas()){
        gana = 1
    }
    return gana
}


fun eligePosValida(i: Int, j: Int, campoBatalla: Batalla): Array<Int> {
    var valores = arrayOf(-1,0,1)
    var correcto = false
    var sumFils = 0
    var sumCols = 0
    do {
        sumFils = valores[Random.nextInt(valores.size)]
        sumCols = valores[Random.nextInt(valores.size)]
        if (i + sumFils >= 0 && i + sumFils < campoBatalla.getCantFilas() && j + sumCols >=0 && j + sumCols < campoBatalla.getCantCols()){
            correcto = true
        }
    }while(!correcto)
    return arrayOf(i + sumFils, j + sumCols)
    }


fun iniciarLegions(legions: ArrayList<Legion?>, nombre : String, cuantas: Int) {
    for (i in 1..cuantas){
        legions.add(factoriaLegion(nombre+i))
    }
}
