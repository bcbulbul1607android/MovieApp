package burakcanbulbul.com.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.constants.MovieDBConstants
import burakcanbulbul.com.movieapp.model.TVSeries
import burakcanbulbul.com.movieapp.widget.RecyclerViewClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.top_rated_tv_series_list.view.*

class TopRatedTVSeriesAdapter() : RecyclerView.Adapter<TopRatedTVSeriesAdapter.ViewHolder>() {

    private lateinit var tvSeries : ArrayList<TVSeries>
    private lateinit var recyclerViewClickListener : RecyclerViewClickListener

    constructor(tvSeries : ArrayList<TVSeries>) : this(){
        this.tvSeries = tvSeries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.top_rated_tv_series_list,parent,false)
        return ViewHolder(itemView)
    }

    fun setOnRecyclerViewClickListener(recyclerViewClickListener: RecyclerViewClickListener){
        this.recyclerViewClickListener = recyclerViewClickListener
    }

    override fun getItemCount(): Int = tvSeries.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvSerie : TVSeries = tvSeries[position]
        holder.bind(tvSerie)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {itemView.setOnClickListener(this)}

        fun bind(tvSerie : TVSeries){
            Picasso.get().load(MovieDBConstants.IMAGE_URL.plus(tvSerie.posterPath)).into(itemView.top_rated_series_image_view)
            itemView.top_rated_series_text_view.text = tvSerie.originalName
        }

        override fun onClick(v: View?) {
            recyclerViewClickListener.onRecyclerViewClick(v,adapterPosition)
        }
    }

    fun addAll(tvSeries : ArrayList<TVSeries>){
        if(this.tvSeries.containsAll(tvSeries).not()){
            this.tvSeries.addAll(tvSeries)
            this.notifyDataSetChanged()
        }
    }
}