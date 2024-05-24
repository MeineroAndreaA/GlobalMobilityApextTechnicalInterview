package com.aam.gmapextechnicalinterview.utils

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

object Json {

    val ASSETS_PATH = "../app/src/test/assets/"
    const val dummyListOfChars = "dummyListOfChars.json"

    @Throws(IOException::class)
    fun readJsonFile(filename: String): String {

        val br = BufferedReader(InputStreamReader(FileInputStream("$ASSETS_PATH$filename")))
        val sb = StringBuilder()
        var line: String? = br.readLine()
        while (line != null) {
            sb.append(line)
            line = br.readLine()
        }
        return sb.toString()
    }
}