package com.example.tomat.testlast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_details.*

class movie_details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        registerForContextMenu(showReview)
        val bundle: Bundle?=intent.extras
        val movie_title= bundle!!.getString("title");
        val movie_overview=bundle!!.getString("overview");
        val movie_releasedate=bundle!!.getString("releasedate")
        val movie_lang=bundle!!.getString("lang")
        val movie_recommend=bundle!!.getString("recommend")
        showTitle.text=movie_title+"\n"
        showOverview.text=movie_overview+"\n"
        showreleasedate.text=movie_releasedate+"\n"
        showLanguage.text=movie_lang+"\n"
        showSuitableorNot.text=movie_recommend+"\n"
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movie_details,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId==R.id.cancelButton){
            val main= Intent(applicationContext,landing_page::class.java)
            finish()
            startActivity(main)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        val bundle:Bundle?=intent.extras
        ratingBar.visibility=View.VISIBLE
        val movie_title_review= bundle!!.getString("title");
        val movie_overview_review=bundle!!.getString("overview");
        val movie_releasedate_review=bundle!!.getString("releasedate")
        val movie_lang_review=bundle!!.getString("lang")
        val movie_recommend_review=bundle!!.getString("recommend")
        val user=bundle!!.getString("userRating")
        val starrating=bundle!!.getFloat("rate")
        showTitle.text=movie_title_review+ "\n"
        showOverview.text=movie_overview_review +"\n"
        showLanguage.text=movie_lang_review +"\n"
        showreleasedate.text=movie_releasedate_review +"\n"
        ratingBar.rating=starrating

    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if(v?.id==R.id.showReview){
            menu?.add(1,1001,1,"Add Review")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==1001){
            val bundle:Bundle?=intent.extras
            val movie_review_title=bundle!!.getString("title");
            val movie_review_desc=bundle!!.getString("desc");
            val movie_review_releasedate=bundle!!.getString("releasedate")
            val movie_review_lang=bundle!!.getString("lang")
            val recommend=bundle!!.getString("recommend")

            val movie_intent=Intent(applicationContext,movie_rater::class.java)
            movie_intent.putExtra("TitleReview",movie_review_title)
            movie_intent.putExtra("overviewReview",movie_review_desc)
            movie_intent.putExtra("DateReview",movie_review_releasedate);
            movie_intent.putExtra("LangReview",movie_review_lang);
            movie_intent.putExtra("RecommendornotReview",recommend)
            finish()
            startActivity(movie_intent)

        }
        return super.onContextItemSelected(item)
    }
}
