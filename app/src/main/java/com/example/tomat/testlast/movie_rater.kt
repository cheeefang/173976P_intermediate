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
        val movie_title=intent.getStringExtra("TitleReview")
        val movie_overview=intent.getStringExtra("DescReview")
        val movie_releasedate=intent.getStringExtra("DateReview")
        val movie_lang=intent.getStringExtra("LangReview")
        val movie_recommend=intent.getStringExtra("RecommendornotReview")
        showTitle.setText("Enter Your review for the movie:"+movie_title)
        showOverview.setText("Movie Description:"+movie_overview+"\n")
        showreleasedate.setText("Movie Release Date:"+movie_releasedate)
        showLanguage.setText("Movie Language"+movie_lang)
        showSuitableorNot.setText("Suitable for Children below 13:"+movie_recommend)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.submitButton){
            val bundle:Bundle?=intent.extras
            val movie_title=intent.getStringExtra("TitleReview")
            val movie_overview=intent.getStringExtra("DescReview")
            val movie_releasedate=intent.getStringExtra("DateReview")
            val movie_lang=intent.getStringExtra("LangReview")
            val movie_recommend=intent.getStringExtra("RecommendornotReiew")
            val userrating=starrating.rating.toFloat()
            val userreview=editreview.text.toString()
            val somethingIntent= Intent(applicationContext,movie_details::class.java)
            somethingIntent.putExtra("movie_title",movie_title)
            somethingIntent.putExtra("movie_overview",movie_overview)
            somethingIntent.putExtra("movie_releasedate",movie_releasedate)
            somethingIntent.putExtra("movie_lang",movie_lang)
            somethingIntent.putExtra("movie_recommend",movie_recommend)
            somethingIntent.putExtra("userrating",userrating)
            somethingIntent.putExtra("userreview",userreview)
            startActivity(somethingIntent)

        }
        return super.onOptionsItemSelected(item)
    }
}
