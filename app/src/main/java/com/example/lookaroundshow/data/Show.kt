package com.example.lookaroundshow.data

data class Show(
    val title: String,
    val region: String,
    val hall: String,
    val duration: String,
    val startDate: String,
    val endDate: String,
    val poster: String,
    val descriptionString: String,
    val descriptionImage: String,
    val isLiked: Boolean,
    val bookLink: String
    )
