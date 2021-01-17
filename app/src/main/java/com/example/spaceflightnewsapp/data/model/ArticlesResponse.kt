package com.example.spaceflightnewsapp.data.model

data class ArticlesResponse(
    val events: List<Event>?,
    val featured: Boolean?,
    val id: String?,
    val imageUrl: String?,
    val launches: List<Launche>?,
    val newsSite: String?,
    val publishedAt: String?,
    val summary: String?,
    val title: String?,
    val url: String?
)






