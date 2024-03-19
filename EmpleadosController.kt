class EmpleadosController(private val printer: Printer){
    private val EmpleadosList = mutableListOf<Empleados>()

    fun RegisterEmpleados(){
      println("Nombre del empleado")
      val nombre = readln()
      println("Apellidos del empleado")
      val apellidos = readln()
        println("Puesto del emplado")
      val puesto = readln()
        println("Numero de telefono del empleado")
        val num_telefono = readln()
        println("Correo electronico del empleado")
        val correo = readln()
        println ("Numero de nomina")
        val nomina = readln()
        val esta_disponible = true

        val addedEmpleados =
            Empleados(nombre, apellidos, puesto, num_telefono, correo, nomina, esta_disponible)
    }
    fun modificarEmpleados(modificadoEmpleados: Empleados, index: Int){
        if (index in EmpleadosList.indices){
            EmpleadosList[index]= modificadoEmpleados
        }
        else{
            printer.printMsg("Indice de empleado incorrecto")
        }
    }
    fun getEmpleadosByIndex(index: Int): Empleados? {
        return if (index in EmpleadosList.indices){
            EmpleadosList[index]
        }
        else {
            printer.printMsg("Indice de habitacion incorrecto")
            null
        }
        }
    fun showEmpleados(){
        if (EmpleadosList.isEmpty()){
            printer.printMsg("No se encontraron los empleados registrados")
        }
        else{
            var contador =1
            for (empleados in EmpleadosList){
                printer.printMsg("$contador" + empleados.getEmpleadosData())
                contador++
            }
        }
    }
    fun No_Empleados_Registrados(): Boolean = EmpleadosList.isEmpty()
}