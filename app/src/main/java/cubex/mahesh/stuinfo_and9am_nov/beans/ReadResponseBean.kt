package cubex.mahesh.stuinfo_and9am_nov.beans

import com.google.gson.annotations.SerializedName

data class ReadResponseBean(@SerializedName("results")
                            val results: List<ResultsItem>?)