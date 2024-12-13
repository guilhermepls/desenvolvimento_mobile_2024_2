package com.example.nighteventsapp.models

import androidx.compose.runtime.mutableStateOf
import com.example.nighteventsapp.R


val eventList = listOf(
    Event(
        id = 1,
        title = "Semi-final da Copa do Brasil 2028 - Quixeramobim x Quixadá",
        description = "Jogo de futebol",
        date = "2028-10-04",
        location = "Estádio do Carneirão",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.futeqxb
    ),
    Event(
        id = 2,
        title = "Semi-final da Copa do Brasil 2028 - Gama do Uruquê x Cruzeiro do Uruquê",
        description = "Jogo de Futebol",
        date = "2028-10-03",
        location = "Campo do Uruquê",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.gamauruque
    ),
    Event(
        id = 3,
        title = "Encontro dos amigos",
        description = "Dia de bebedeira com os amigos",
        date = "2024-12-20",
        location = "Bar da Sônia - Uruquê",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.bardasonia
    ),
    Event(
        id = 4,
        title = "Forró do Bunitim na Garagem do Forró",
        description = "Organização: Chico Antônio e Família.",
        date = "2020-01-02",
        location = "Garagem do Forró - Uruquê",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.garagem_forro
    ),
)