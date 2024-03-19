class Mudanza (
    val peso:Double,
    val distancia: Double,
    val seguro: Boolean,
)
{
    fun getMudanzaData():String {
        return "Peso de la mudanza: $peso, Distancia en Km: $distancia, ¿La mudanza incluye seguro? $seguro"
    }
}