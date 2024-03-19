class ClienteController (private val printer: Printer){
    private val ClienteList: MutableList<Cliente> = mutableListOf()

    fun registerCliente(){
        println("Ingrese el nombre del cliente")
        val nombre = readln()
        println("¿Cuelas son sus apellidos?")
        val apellidos = readln()
        println("¿Cual es su direccion?")
        val direccion = readln()
        println("¿Cual es su numero de telefono?")
        val num_telefono = readln()
        println("¿Cual es su correo electronico?")
        val correo = readln()
        println("¿Cual es su RFC?")
        val rfc = readln()

        val addedCliente = Cliente(nombre, apellidos, direccion, num_telefono, correo, rfc)
        ClienteList.add(addedCliente)
    }
    fun showCliente(){
        if (ClienteList.isEmpty()){
            printer.printMsg("No se encuentra registrado el cliente")
        }
        else{
            var contador=1
            for (cliente in ClienteList){
                printer.printMsg("$cliente" + cliente.getClienteData())
                contador++
            }
        }
    }
    fun Cargar_Cliente_BD(){
    }
    fun getClienteByIndex(index: Int): Cliente = ClienteList[index]

    fun No_Cliente_Registrado(): Boolean = ClienteList.isEmpty()
}