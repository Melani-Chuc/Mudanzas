class Cliente (
    val nombre:String,
    val apellidos:String,
    val direccion:String,
    val num_telefono:Int,
    val correo:String,
    val rfc:String,
)

{
    fun getClienteData():String
    {
        return "Nombre: $nombre $apellidos, Direccion: $direccion, Numero de telefono: $num_telefono, Correo electronico: $correo, RFC: $rfc"
    }
    fun addSolicitud (solicitud:Solicitud){

    }
}