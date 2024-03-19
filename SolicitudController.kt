class SolicitudController (private val printer: Printer){
    private val SolicitudList = mutableListOf<Solicitud>()

    fun CrearSolicitud(cliente: Cliente, empleado: Empleados, mudanza: Mudanza){
       println("Fecha")
       val fecha = readln()
       println ("Hora")
       val hora = readln()
        println ("Detalles de la mudanza")
        val detalles = readln()
        println("Direccion")
        val direccion = readln()
        println ("Peso total de la mudanza")
        val peso_total = readln().toDouble()
        println("Distancia en km de la mudanza")
        val distancia_total = readln().toDoubleOrNull() ?: 0.0
        println("Persona que registro la solucitud")
        val nombre_registro = readln()

        val addedSolicitud = Solicitud( cliente, empleado, mudanza, fecha, hora, detalles, direccion, peso_total, distancia_total, nombre_registro)

        addedSolicitud.calcularTotal()
        cliente.addSolicitud(addedSolicitud)
        SolicitudList.add(addedSolicitud)
    }
    fun showSolicitud(){
        if (SolicitudList.isEmpty()){
            printer.printMsg("No hay solicitud añadida")
        }
        else{
            var contador= 1
            for (solicitud in SolicitudList){
                printer.printMsg("$contador" + solicitud.getSolicitudData())
                contador++
            }
        }
    }
}