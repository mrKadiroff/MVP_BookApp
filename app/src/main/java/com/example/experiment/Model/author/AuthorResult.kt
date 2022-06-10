package com.example.experiment.Model.author

data class AuthorResult(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)