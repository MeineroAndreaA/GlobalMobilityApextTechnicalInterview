package com.aam.gmapextechnicalinterview.presentation.view_model

enum class ErrorTextHelpers(val error_mesage : String) {
    ERROR_CHARACTER_NOT_FOUND("No encontramos el personaje que buscaste"),
    ERROR_SPECIES_NOT_FOUND("No encontramos ningun personaje de la especie seleccionada... que raro, no?"),
    ERROR_API("La API de Rick y Morty nos ha abandonado... o fue tu internet?")
}