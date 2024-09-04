package com.loki.customrm.resource

import android.content.Context
import android.graphics.drawable.Drawable
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object CustomResourceManager {

    fun loadConfig(context: Context, customLocale: String): String? {
        val assetManager = context.assets
        val filePath = "custom-$customLocale/config.json"

        return try {
            val inputStream = assetManager.open(filePath)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            reader.forEachLine { line ->
                stringBuilder.append(line)
            }
            reader.close()
            stringBuilder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun loadDrawable(context: Context, customLocale: String, drawableName: String): Drawable? {
        val assetManager = context.assets
        val filePath = "$customLocale/$drawableName"

        return try {
            val inputStream: InputStream = assetManager.open(filePath)
            Drawable.createFromStream(inputStream, null)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}