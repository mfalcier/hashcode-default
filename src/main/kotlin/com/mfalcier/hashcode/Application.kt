package com.mfalcier.hashcode

import java.io.File
import java.io.InputStream

fun main(args : Array<String>) {
    if (args.isEmpty()) {
        println("Please provide a name as a command-line argument")
        return
    }

    val matrix = convertFileIntoMatrix(args[0])
    val data = matrix[0]
    matrix.removeAt(0)

    /*for (cells in superMatrix) {
        for (cell in cells) {
            print(cell)
        }
        println("|")
    }*/

    println("Everything Done.")
}

fun convertFileIntoMatrix(file: String): MutableList<MutableList<String>> {
    val superMatrix = mutableListOf<MutableList<String>>()

    val inputStream: InputStream = File("/Users/marco.falcier/sources/hashcode-default/input$file").inputStream()
    val rows = inputStream.bufferedReader().use { it.readLines() }

    for(row in rows) {
        val newRow = mutableListOf<String>()
        row.toCharArray().mapTo(newRow) { it.toString() }
        superMatrix.add(newRow)
    }

    return superMatrix
}