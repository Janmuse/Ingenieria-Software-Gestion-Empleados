package com.smarven.gestionem1

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime

object TimeUtils {


     private fun horasPorRango(registros: List<Registro>, inicio: LocalDate, fin: LocalDate): Double {
        val filtrados = registros.filter {
            val fecha = LocalDateTime.parse(it.fecha).toLocalDate()
            fecha in inicio..fin
        }


        var total = 0.0
        for (i in 0 until filtrados.size - 1) {
            if (filtrados[i].tipo == "ENTRADA" && filtrados[i + 1].tipo == "SALIDA") {
                val ini = LocalDateTime.parse(filtrados[i].fecha)
                val finHora = LocalDateTime.parse(filtrados[i + 1].fecha)
                total += Duration.between(ini, finHora).toMinutes() / 60.0
            }
        }
        return total
    }

    fun calcularHorasDelDia(
        registros: List<Registro>,
        dia: LocalDate
    ): Double {
        var total = 0.0

        val registrosDelDia = registros
            .map {
                it to LocalDateTime.parse(it.fecha)
            }
            .filter { (_, fecha) ->
                fecha.toLocalDate() == dia
            }
            .sortedBy { it.second }

        for (i in 0 until registrosDelDia.size - 1) {
            val actual = registrosDelDia[i]
            val siguiente = registrosDelDia[i + 1]

            if (
                actual.first.tipo == "ENTRADA" &&
                siguiente.first.tipo == "SALIDA"
            ) {
                val inicio = actual.second
                val fin = siguiente.second
                total += Duration.between(inicio, fin).toMinutes() / 60.0
            }
        }

        return total
    }

    fun horasSemana(registros: List<Registro>): Double {
        val hoy = LocalDate.now()
        val inicio = hoy.with(DayOfWeek.MONDAY)
        val fin = hoy.with(DayOfWeek.SUNDAY)
        return horasPorRango(registros, inicio, fin)
    }


    fun horasMes(registros: List<Registro>): Double {
        val hoy = LocalDate.now()
        val inicio = hoy.withDayOfMonth(1)
        val fin = hoy.withDayOfMonth(hoy.lengthOfMonth())
        return horasPorRango(registros, inicio, fin)
    }


    fun salarioQuincenal(horasMes: Double, pagoHora: Double = 50.0): Double {
        return (horasMes / 2) * pagoHora
    }
}