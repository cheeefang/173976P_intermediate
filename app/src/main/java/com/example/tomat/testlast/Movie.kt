package com.example.tomat.testlast



class Movie(var movie_name:String,var movie_overview:String,var movie_lang:String,
            var movie_release_date:String,var movie_suitable:Boolean,
            var movie_violence:Boolean,var movie_foul_lang:Boolean){

    var StarNum:Float=0.toFloat()
    var movie_review:String=""

    fun updateData(name:String,desc:String,lang:String,date:String,suitable:
    Boolean,violence:Boolean,foullang:Boolean){
        movie_name=name
        movie_overview=desc
        movie_lang=lang
        movie_release_date=date
        movie_suitable=suitable
        movie_violence=violence
        movie_foul_lang=foullang
    }

    fun updateReviewData(starNum:Float ,review:String){
        StarNum=starNum
        movie_review=review

    }
}