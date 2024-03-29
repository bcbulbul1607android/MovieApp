package burakcanbulbul.com.movieapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.Movie
import burakcanbulbul.com.movieapp.widget.RecyclerViewClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.now_playing_movies_list.view.*
import kotlinx.android.synthetic.main.top_rated_movies_list.view.*

class NowPlayingMoviesAdapter() : RecyclerView.Adapter<NowPlayingMoviesAdapter.ViewHolder>() {

    private lateinit var movies : ArrayList<Movie>
    private lateinit var recyclerViewClickListener : RecyclerViewClickListener

    constructor(movies : ArrayList<Movie>) : this(){
        this.movies = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.now_playing_movies_list,parent,false)
        return ViewHolder(itemView)
    }

    fun setOnRecyclerViewClickListener(recyclerViewClickListener: RecyclerViewClickListener){
        this.recyclerViewClickListener = recyclerViewClickListener
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie : Movie = movies[position]
        holder.bind(movie)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {itemView.setOnClickListener(this)}

        fun bind(movie : Movie){
            Picasso.get().load(MovieDBConstants.IMAGE_URL.plus(movie.posterPath)).into(itemView.now_playing_movies_image_view)
            itemView.now_playing_movies_text_view.text = movie.originalTitle
        }

        override fun onClick(v: View?) {
            recyclerViewClickListener.onRecyclerViewClick(v,adapterPosition, MovieDBConstants.NOW_PLAYING_MOVIES)
        }
    }

    fun addAll(movies : ArrayList<Movie>){
        if(this.movies.containsAll(movies).not()){
            this.movies.addAll(movies)
            this.notifyDataSetChanged()
        }
    }
}