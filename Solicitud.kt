class Solicitud (
    val cliente: Cliente,
    val empleado: Empleados,
    val mudanza:Mudanza,
    val fecha: String,
    val hora: String,
    val direccion:String,
    val detalles: String,
    val peso_total: Double,
    val distancia_total:Double,
    val nombre_registro:String,
    private var esta_cancelado:Boolean=false
)
{
    init{
        calcularTotal()
    }
    fun calcularTotal(): Double{
        var precio_total=peso_total * mudanza.peso
        precio_total += distancia_total * mudanza.distancia

        if (mudanza.seguro){
            precio_total += calcularCostoSeguro()
        }
        return precio_total
    }
   fun calcularCostoSeguro(): Double{
       return 150.00
   }
    fun cancelarSolicitud(){
        esta_cancelado=true
    }
    fun actualizar_peso(peso_total:Double){
        this.peso_total=peso_total
        calcularTotal()
    }
  fun actualizar_distancia(distancia_total:Double){
      this.distancia_total=distancia_total
      calcularTotal()
  }
    fun getSolicitudData(): String {
        return "Fecha: $fecha, Hora: $hora, Cliente: $cliente, Empleado: $empleado, Direccion: $direccion, Peso total de la mudanza: $peso_total, Distancia total de la mudanza: $distancia_total, Detalles: $detalles, Persona que registro la solicitud: $nombre_registro"
    }
}