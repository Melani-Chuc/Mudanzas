class MenuController {
    private val printer = Printer()
    private val ClienteController = ClienteController(printer)
    private val EmpleadosController = EmpleadosController(printer)
    private val SolicitudController = SolicitudController(printer)
    private val MudanzaController = MudanzaController(printer)

    fun showMenu(){
        printer.apply{
            printMsg("Ingrese una opcion")
            printMsg("1. Registrar cliente")
            printMsg("2. Registrar empleado")
            printMsg("3. Crear solicitud de mudanza")
            printMsg("4. Mostrar Cliente")
            printMsg("5. Mostrar empleado")
            printMsg("6. Mostrar solicitud de mudanza")

            val seleccionOpcion = readln().toInt()
            validarOpcion(seleccionOpcion)
        }
    }
   fun validarOpcion(seleccionOpcion:Int){
       when (seleccionOpcion){
           1 -> {
               ClienteController.registerCliente()
               println("")
               showMenu()
           }
           2 ->{
               EmpleadosController.RegisterEmpleados()
               println("")
               showMenu()
           }
           3 ->{
               seleccionCliente_Empleados_Mudanza_()
               println("")
               showMenu()
           }
           4 ->{
               ClienteController.showCliente()
               print("")
               showMenu()
           }
           5 ->{
               EmpleadosController.showEmpleados()
               println("")
               showMenu()
           }
           6 ->{
               SolicitudController.showSolicitud()
               println("")
               showMenu()
           }
       }
   }
    fun seleccionCliente_Empleados_Mudanza(){
        if (ClienteController.No_Cliente_Registrado()){
            printer.printMsg("No se encuentra los clientes registrados")
            showMenu()
            return
        }
        if (EmpleadosController.No_Empleados_Registrados()){
            printer.printMsg("No se encuentra los Empleados registrados")
            showMenu()
            return
        }
        if MudanzaController.No_Mudanza_Registrada()){
            printer.printMsg("No se encuentra la mudanza registrada")
            showMenu()
            return
        }
        printer.printMsg("Selecciona un cliente")
        ClienteController.showCliente()
        val SeleccionClienteIndex = readln().toInt()
        val cliente = ClienteController.getClienteByIndex(SeleccionClienteIndex -1)

        printer.printMsg("Selecciona un empleado")
        EmpleadosController.showEmpleados()
        val SeleccionEmpleadosIndex = readln().toInt()
        val empleados = EmpleadosController.getEmpleadosByIndex(SeleccionEmpleadosIndex -1)

        printer.printMsg("Selecciona una mudanza")
        MudanzaController.showMudanza()
        val SeleccionMudanzaIndex = readln().toInt()
        val mudanza = MudanzaController.getMudanzaByIndex(SeleccionMudanzaIndex -1)

        empleados?.let{
            SolicitudController.CrearSolicitud(cliente, it, mudanza!!)
        }?: {showMenu()}
    }
}