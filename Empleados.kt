class Empleados (
   val nombre:String,
   val apellidos:String,
   val puesto:String,
    val num_telefono:Int,
    val correo:String,
    val nomina:String,
    val disponibilidad:Boolean,
    val esta_disponible:Boolean=true
)
{
    fun getEmpleadosData():String
    {
        return "Nombre: $nombre $apellidos, Puesto: $puesto, Numero de telefono: $num_telefono, Correo: $correo, Disponibilidad: $disponibilidad ${if (esta_disponible) "Si" else "No"}"
    }
}