package burakcanbulbul.com.movieapp.ui.detail

import burakcanbulbul.com.movieapp.model.MovieCredit
import burakcanbulbul.com.movieapp.model.MovieDetail
import burakcanbulbul.com.movieapp.mvp.MainPresenterImpl
import burakcanbulbul.com.movieapp.mvp.MainView
import burakcanbulbul.com.movieapp.remote.MovieDBAppDataSource

interface DetailContract {


    interface View : MainView , OnResponseListener{
        fun init()
        fun initPresenter()
        fun fetchDetail()
        fun fetchCredit()
    }

    interface OnResponseListener{
        fun onDetailSuccess(movieDetail : MovieDetail)
        fun onCreditSuccess(movieCredit: MovieCredit)
    }

    abstract class Presenter : MainPresenterImpl<View>() {

        abstract fun setDataSource(movieDBAppDataSource: MovieDBAppDataSource)
        abstract fun setOnResponseListener(onResponseListener: OnResponseListener)
        abstract fun getDetail(apiKey:String, id : Int)
        abstract fun getCredit(apiKey: String, id : Int)
    }
}