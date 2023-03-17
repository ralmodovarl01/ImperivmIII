package Formaciones

open class Legion {

    private var nombre : String
    private var numero : Int
    private var legatus : Oficial
    private var tribunos : ArrayList<Oficial>  = ArrayList(2)
    private var tropas = ArrayList<Tropa>()


    constructor(nombre: String, numero: Int, legatus: Oficial, tribunoI : Oficial, tribunoII: Oficial) {
        this.nombre = nombre
        this.numero = numero
        this.legatus = legatus
        this.tribunos.add(tribunoI)
        this.tribunos.add(tribunoII)
    }

    fun getNombre():String{
        return this.nombre
    }

    fun setNombre(n:String){
         this.nombre=n
    }

    fun addTropa(t : Tropa){
        this.tropas.add(t)
    }

    override fun toString(): String {
        //return "Formaciones.Legion(nombre='$nombre', numero=$numero, legatus=$legatus, tribunos=$tribunos, tropas=$tropas)"
        //return "Formaciones.Legion(nombre='$nombre', numero=$numero, legatus=$legatus, tribunos=$tribunos, tropas=${tropas.size})"
        return nombre
    }

    fun cantTropas(): Int {
        var cant = 0
        for (e in this.tropas){
            if (e is Auxilia){
                cant++
            }
            if (e is Triari){
                cant+=2
            }
            if (e is Velite){
                cant+=3
            }
            if (e is Equite){
                cant+=4
            }
        }
        return cant
    }


    fun getCuantsaTropas():Int{
        return this.tropas.size
    }

    fun getTropaAt(i : Int) : Tropa{
        return this.tropas[i]
    }


}