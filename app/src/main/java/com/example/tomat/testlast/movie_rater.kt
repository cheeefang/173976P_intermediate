package com.example.tomat.testlast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_rater.*
import kotlinx.android.synthetic.main.activity_movie_rater.view.*

class movie_rater : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.review_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
        var something=intent.getStringExtra("TitleReview")
        var something2=intent.getStringExtra("DescReview")
        var something3=intent.getStringExtra("DateReview")
        var something4=intent.getStringExtra("LangReview")
        var something5=intent.getStringExtra("RecommendornotReview")
        showTitle.setText(something)
        showOverview.setText(something2)
        showreleasedate.setText(something3)
        showLanguage.setText(something4)
        showSuitableorNot.setText(something5)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.submitButton){
            var something=intent.getStringExtra("TitleReview")
            var something2=intent.getStringExtra("DescReview")
            var something3=intent.getStringExtra("DateReview")
            var something4=intent.getStringExtra("LangReview")
            var something5=intent.getStringExtra("RecommendornotReview")
            val userrating=starrating.rating.toString()
            val userreview=editreview.text.toString()
            val somethingIntent= Intent(applicationContext,movie_details::class.java)
            somethingIntent.putExtra("something",something)
            somethingIntent.putExtra("something2",something2)
            somethingIntent.putExtra("something3",something3)
            somethingIntent.putExtra("something4",something4)
            somethingIntent.putExtra("something5",something5)
            startActivity(somethingIntent)

        }
        return super.onOptionsItemSelected(item)
    }
}
