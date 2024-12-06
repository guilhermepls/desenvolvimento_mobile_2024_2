package com.example.zooapp.models

import com.example.zooapp.R

data class Animal(
    val id: Int,
    val name: String,
    val species: String,
    val imageRes: Int,
    val description: String,
    val curiosities: String,
    var isFavorite: Boolean = false
)

val AnimalList = listOf(
    Animal(
        id = 1,
        name = "Simba",
        species = "Leão",
        imageRes = R.drawable.simba,
        description = "Simba é o protagonista do clássico da Disney 'O Rei Leão'. Ele é o filho do rei Mufasa e herdeiro do trono das Terras do Reino.",
        curiosities = "O nome Simba significa 'leão' em suaíli. Sua jornada foi inspirada em elementos de Hamlet, de Shakespeare.",
    ),
    Animal(
        id = 2,
        name = "Scooby-Doo",
        species = "Cachorro, Dogue Alemão",
        imageRes = R.drawable.scooby_doo,
        description = "Scooby-Doo é um cachorro falante da série de mistérios 'Scooby-Doo', famoso por resolver mistérios ao lado de seus amigos da Máquina de Mistério.",
        curiosities = "Ele tem medo de fantasmas, mas é movido por Biscoitos Scooby.",
    ),
    Animal(
        id = 3,
        name = "Jerry",
        species = "Camundongo",
        imageRes = R.drawable.jerry,
        description = "Jerry é um camundongo esperto da série de animação 'Tom and Jerry', conhecido por sua astúcia ao escapar do gato Tom.",
        curiosities = "Embora seja pequeno, Jerry frequentemente supera Tom usando inteligência e truques criativos.",
    ),
    Animal(
        id = 4,
        name = "Pato Donald",
        species = "Pato",
        imageRes = R.drawable.pato_donald,
        description = "Donald Duck é um personagem clássico da Disney, famoso por seu temperamento explosivo e voz distinta.",
        curiosities = "Donald tem um tio muito famoso, o Tio Patinhas, e três sobrinhos chamados Huguinho, Zezinho e Luisinho.",
    ),
    Animal(
        id = 5,
        name = "Pernalonga",
        species = "Coelho",
        imageRes = R.drawable.pernalonga,
        description = "Pernalonga é o famoso coelho sarcástico da série 'Looney Tunes', conhecido por sua frase icônica 'O que é que há, velhinho?'",
        curiosities = "Sua personalidade foi inspirada em Groucho Marx, e ele tem uma cenoura em mãos.",
    ),
    Animal(
        id = 6,
        name = "Pikachu",
        species = "Roedor elétrico",
        imageRes = R.drawable.pikachu,
        description = "Pikachu é o mascote da franquia Pokémon, conhecida por suas habilidades elétricas e sua lealdade ao treinador Ash.",
        curiosities = "Pikachu foi originalmente criado para ser um Pokémon simples, mas se tornou um fenômeno global.",
    ),
    Animal(
        id = 7,
        name = "Garfield",
        species = "Gato",
        imageRes = R.drawable.garfield,
        description = "Garfield é um gato laranja famoso por sua preguiça, sarcasmo e amor por lasanha.",
        curiosities = "Ele foi criado por Jim Davis e é a estrela de uma das tirinhas mais populares do mundo",
    ),
    Animal(
        id = 8,
        name = "Po",
        species = "Panda",
        imageRes = R.drawable.po,
        description = "Po é o protagonista de 'Kung Fu Panda', um panda desajeitado que se torna o lendário Dragão Guerreiro",
        curiosities = "Embora seja um mestre de kung fu, Po adora comer bolinhos de massa (dumplings), Jerry frequentemente supera Tom usando inteligência e truques criativos.",
    ),
)