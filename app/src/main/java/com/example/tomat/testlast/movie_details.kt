package com.example.tomat.testlast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_movie_details.*

class movie_details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        intent.getStringExtra("title");
        intent.getStringExtra("desc");
        intent.getStringExtra("releasedate")
        intent.getStringExtra("lang")
        intent.getStringExtra("recommend")
        showTitle.setText(intent.getStringExtra("title"));
        showOverview.setText(intent.getStringExtra("desc"));
        showreleasedate.setText(intent.getStringExtra("releasedate"));
        showLanguage.setText(intent.getStringExtra("lang"));
        showSuitableorNot.setText(intent.getStringExtra("lang"));
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

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if(v?.id==R.id.showReview){
            menu?.add(1,1001,1,"Add Review")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==1001){
            var title= intent.getStringExtra("title");
            var desc=intent.getStringExtra("desc");
            var releasedate=intent.getStringExtra("releasedate")
            var lang=intent.getStringExtra("lang")
            var recommend=intent.getStringExtra("recommend")
            showTitle.setText(intent.getStringExtra("title"));
            showOverview.setText(intent.getStringExtra("desc"));
            showreleasedate.setText(intent.getStringExtra("releasedate"));
            showLanguage.setText(intent.getStringExtra("lang"));
            showSuitableorNot.setText(intent.getStringExtra("lang"));
            val movie_intent=Intent(applicationContext,movie_rater::class.java)
            movie_intent.putExtra("TitleReview",title)
            movie_intent.putExtra("DescReview",desc)
            movie_intent.putExtra("DateReview",releasedate);
            movie_intent.putExtra("LangReview",lang);
            movie_intent.putExtra("RecommendornotReview",recommend)
            startActivity(movie_intent)

        }
        return super.onContextItemSelected(item)
    }
}
