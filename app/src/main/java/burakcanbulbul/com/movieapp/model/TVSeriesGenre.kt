package burakcanbulbul.com.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class TVSeriesGenre constructor(@SerializedName("id") @Expose var id : Int,
                                     @SerializedName("name") @Expose var name : String) : Serializable