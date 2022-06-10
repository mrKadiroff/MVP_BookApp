package com.example.experiment.Model.title

data class TitleResult(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)