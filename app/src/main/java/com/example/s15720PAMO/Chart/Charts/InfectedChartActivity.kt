package com.example.s15720PAMO.Chart.Charts

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.s15720PAMO.R

class InfectedChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_infected)
        val webView = findViewById<WebView>(R.id.web_view)
        val unencodedHtml = "<a href=\"https://www.statista.com/statistics/1043366/novel-coronavirus-2019ncov-cases-worldwide-by-country/\" rel=\"nofollow\"><img src=\"https://www.statista.com/graphic/1/1043366/novel-coronavirus-2019ncov-cases-worldwide-by-country.jpg\" alt=\"Statistic: Number of novel coronavirus (COVID-19) cases worldwide as of April 1, 2020, by country* | Statista\" style=\"width: 100%; height: auto !important; max-width:1000px;-ms-interpolation-mode: bicubic;\"/></a><br />Find more statistics at  <a href=\"https://www.statista.com\" rel=\"nofollow\">Statista</a>"
        webView.loadData(unencodedHtml, "text/html; charset=utf-8", "UTF-8")
    }
}