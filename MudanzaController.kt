class MudanzaController (private val printer: Printer){
    private val MudanzaList = mutableListOf<Mudanza>()

    fun registerMudanza(){
        println("Precio por kg de mudanza")
        val peso = readln().toDouble()
        println("Distancia en km de la mudanza")
        val distancia = readln().toDouble()
        println("¿Incluye seguro?")
        val seguro = false

       val addedMudanza = Mudanza(peso, distancia, seguro)
       MudanzaList.add(addedMudanza)
    }
    fun getMudanzaByIndex(index: Int): Mudanza?{
        return if (index in MudanzaList.indices){
            MudanzaList[index]
        }
        else{
            printer.printMsg("Indice de mudanza incorrecto")
            null
        }
    }
    fun showMudanza(){
        if (MudanzaList.isEmpty()){
            printer.printMsg("No se encontro la mudanza registrada")
        }
        else{
            var contador = 1
            for (mudanza in MudanzaList){
                printer.printMsg("$contador" + mudanza.getMudanzaData())
                contador++
            }
        }
    }
   fun No_Mudanza_Registrada():Boolean = MudanzaList.isEmpty()
}