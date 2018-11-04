package cubex.mahesh.stuinfo_and9am_nov.beans

import com.google.gson.annotations.SerializedName

data class ResultsItem(@SerializedName("gender")
                       val gender: String = "",
                       @SerializedName("name")
                       val name: String = "",
                       @SerializedName("qual")
                       val qual: String = "",
                       @SerializedName("yop")
                       val yop: Int = 0)