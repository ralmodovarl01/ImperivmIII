import Formaciones.Legion
import kotlin.random.Random

class Batalla {


   private var campo = Array(7){Array<Any?>(3){null} }

   fun iniciarCampo(legionsJC: ArrayList<Legion?>, legionsPO: ArrayList<Legion?>) {
      for (i in campo.indices){
         campo[i][1] = "R"
      }
      campo[2][1] = "P"
      campo[5][1] = "P"
      //Colocar a JC
      var i = 0
      var pos = 0
      while(i<legionsJC.size){
         pos = Random.nextInt(campo.size)
         if (campo[pos][0]==null){
            campo[pos][0] = legionsJC[i]
            i++
         }
      }
      //Colocar a PO
      i = 0
      while(i<legionsPO.size){
         pos = Random.nextInt(campo.size)
         if (campo[pos][2]==null){
            campo[pos][2] = legionsPO[i]
            i++
         }
      }
   }


   fun getCantFilas() = this.campo.size

   fun getCantCols() = this.campo[0].size

   fun getCampo(i: Int, j: Int): Any? = this.campo[i][j]

   fun setCampo(i: Int, j: Int, ele : Any?) {
      this.campo[i][j] = ele
   }


   override fun toString(): String {
      var cad=""
      for (i in campo.indices){
         for (j in campo[i].indices){
            if (campo[i][j] == null){
               cad += " \t"
            }
            else {
               cad= cad + " " +  campo[i][j].toString() + "\t"
            }
         }
         cad+= "\n"
      }
      return cad
   }


   //Estos dos métodos siguientes se pueden unificar en uno solo.
   fun cuantasJulioCesar(): Int {
      var cuantas = 0

      for (i in campo.indices) {
         for (j in campo[i].indices) {
            if (campo[i][j] != null) {
               if (campo[i][j] is Legion) {
                  var l = campo[i][j] as Legion
                  if (l.getNombre().startsWith("J")) {
                     cuantas++
                  }
               }
            }
         }
      }
      return cuantas
   }

   fun cuantasPompeyo(): Int {
      var cuantas = 0

      for (i in campo.indices) {
         for (j in campo[i].indices) {
            if (campo[i][j] != null) {
               if (campo[i][j] is Legion) {
                  var l = campo[i][j] as Legion
                  if (l.getNombre().startsWith("P")) {
                     cuantas++
                  }
               }
            }
         }
      }
      return cuantas
   }


}