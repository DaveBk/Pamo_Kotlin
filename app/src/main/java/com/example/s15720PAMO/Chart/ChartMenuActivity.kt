package com.example.s15720PAMO.Chart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.s15720PAMO.Chart.Charts.DeathChartActivity
import com.example.s15720PAMO.Chart.Charts.InfectedChartActivity
import com.example.s15720PAMO.Chart.Charts.RecoveriesChartActivity
import com.example.s15720PAMO.R

class ChartMenuActivity : AppCompatActivity() {
    private var buttonInfected: Button? = null
    private var buttonCure: Button? = null
    private var buttonDeath: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_chart)
        buttonInfected = findViewById(R.id.button_infected_chart)
        buttonInfected?.setOnClickListener(View.OnClickListener { openInfectedActivity() })
        buttonCure = findViewById(R.id.button_cure_chart)
        buttonCure?.setOnClickListener(View.OnClickListener { openCureActivity() })
        buttonDeath = findViewById(R.id.button_death_chart)
        buttonDeath?.setOnClickListener(View.OnClickListener { openDeathActivity() })
    }

    fun openInfectedActivity() {
        val intent = Intent(this, InfectedChartActivity::class.java)
        startActivity(intent)
    }

    fun openCureActivity() {
        val intent = Intent(this, RecoveriesChartActivity::class.java)
        startActivity(intent)
    }

    fun openDeathActivity() {
        val intent = Intent(this, DeathChartActivity::class.java)
        startActivity(intent)
    }
}