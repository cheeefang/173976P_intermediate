package com.example.tomat.testlast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.add) {
            val checkmoviename = editmoviename.text
            val checkmoviedesc = editmoviedesc.text
            val checkdate = editreleasedate.text
            if (checkmoviename.isNullOrEmpty()) {
                editmoviename.error = "Field Empty"
            }
            if (checkmoviedesc.isNullOrEmpty()) {
                editmoviedesc.error = "Field Empty"
            }
            if (checkdate.isNullOrEmpty()) {
                editreleasedate.error = "Field Empty"
            }
            if (checkmoviename.isNotEmpty() && checkmoviedesc.isNotEmpty() && checkdate.isNotEmpty()) {
                showMovie()
            }

        } else if (item?.itemId == R.id.clear) {
            editmoviename.text.clear()
            editmoviedesc.text.clear()
            editreleasedate.text.clear()
            eng.isChecked = true
            notsuitable.isChecked = false
            violence.visibility = View.GONE
            violence.isEnabled = false
            violence.isChecked = false
            langused.visibility = View.GONE
            langused.isEnabled = false
            langused.isChecked = false
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.landing_page, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun MovieRating() {
        notsuitable.setOnClickListener {
            if (notsuitable.isChecked) {
                violence.visibility = View.VISIBLE
                langused.isEnabled = true
                violence.isEnabled = true
                langused.visibility = View.VISIBLE

            } else {
                violence.visibility = View.GONE
                violence.isChecked = false
                violence.isEnabled = false
                langused.isEnabled = false
                langused.isChecked = false
                langused.visibility = View.GONE
            }
        }
    }

    private fun movieRating(){
        notsuitable.setOnClickListener {
            if (notsuitable.isChecked) {
                violence.visibility = View.VISIBLE
                langused.visibility = View.VISIBLE
                violence.isEnabled=true
                langused.isEnabled=true
            } else {
                violence.visibility = View.GONE
                violence.isChecked = false
                langused.visibility = View.GONE
                langused.isChecked = false
                violence.isEnabled=false
                langused.isEnabled=false
            }
        }
    }

    private fun showMovie() {
        var lang = ""
        if (eng.isChecked) {
            lang = eng.text.toString()
        } else if (chi.isChecked) {
            lang = chi.text.toString()
        } else if (malay.isChecked) {
            lang = malay.text.toString()
        } else if (tamil.isChecked) {
            lang = tamil.text.toString()
        } else {
            lang = eng.text.toString()
        }
        var notsuited = ""
        if (notsuitable.isChecked) {
            notsuited = "false"

        } else {
            notsuited = "true"
        }
        var violentornot = ""
        if (violence.isChecked) {
            violentornot = violence.text.toString()
        } else {
            violentornot = "Not Applicable"
        }
        var foullangornot = ""
        if (langused.isChecked) {
            foullangornot = "Foul Language"
        } else {
            foullangornot = "NA"
        }
        var recommend = ""
        if (notsuited == "true") {
            recommend = "Yes"
        } else {
            recommend = "No"
        }
        val title = editmoviename.text.toString()
        val desc = editmoviedesc.text.toString()
        val releasedate = editreleasedate.text.toString()

        val movieInt = Intent(applicationContext, showMovie()::class.java)
        movieInt.putExtra("title", title)
        movieInt.putExtra("desc", desc)
        movieInt.putExtra("releasedate", releasedate)
        movieInt.putExtra("lang", lang)
        movieInt.putExtra("recommend", recommend)
        startActivity(movieInt)

    }
}
