package com.example.customrm.resource

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

open class BaseActivity : AppCompatActivity() {

    val loc = "two"

    override fun onCreate(savedInstanceState: Bundle?) {
        setLocale(this, loc)
        super.onCreate(savedInstanceState)
    }

    private fun setLocale(activity: Activity, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = activity.resources
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}