package com.ui.bookmorning

// oop , algebra type
// oop -> Restrict inheritance hierarchy

sealed class PrimaryColor

object Red : PrimaryColor()
object Green : PrimaryColor()
object Blue : PrimaryColor()


fun main() {
    val color = generateColor()

    when (color) {
        Blue -> {}
        Green -> {}
        Red -> {}
    }
}

fun generateColor(): PrimaryColor = Red

// data class , object
