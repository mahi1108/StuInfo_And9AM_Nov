package cubex.mahesh.stuinfo_and9am_nov

import cubex.mahesh.stuinfo_and9am_nov.beans.InsertResponseBean
import cubex.mahesh.stuinfo_and9am_nov.beans.ReadResponseBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StuInfoAPI {

    @GET("ws/sinfo/insert/{name}/{gender}/{qual}/{yop}")
    fun insert(@Path("name") name:String,
               @Path("gender") gender:String,
               @Path("qual") qual:String,
               @Path("yop") yop:Int) : Call<InsertResponseBean>
    @GET("ws/sinfo/read")
    fun read( ):Call<ReadResponseBean>
}