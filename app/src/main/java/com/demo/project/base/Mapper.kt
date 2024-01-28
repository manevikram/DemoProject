package com.demo.project.base

interface Mapper<F,T> {
    fun mapFrom(from:F):T
}