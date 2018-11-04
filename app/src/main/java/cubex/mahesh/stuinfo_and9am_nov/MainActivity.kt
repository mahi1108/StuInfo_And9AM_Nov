package cubex.mahesh.stuinfo_and9am_nov

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import cubex.mahesh.stuinfo_and9am_nov.beans.InsertResponseBean
import cubex.mahesh.stuinfo_and9am_nov.beans.ReadResponseBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var r = Retrofit.Builder().
            addConverterFactory(GsonConverterFactory.create()).
      baseUrl("http://10.0.0.2:8080/And7AMNov/").
                build()
        var api = r.create(StuInfoAPI::class.java)

        insert.setOnClickListener {

            var call = api.insert(et1.text.toString(),
                        et2.text.toString(),et3.text.toString(),
                        et4.text.toString().toInt())
            call.enqueue(object:Callback<InsertResponseBean>{
                override fun onResponse(call: Call<InsertResponseBean>, response: Response<InsertResponseBean>) {

                    var bean = response.body()

                Toast.makeText(this@MainActivity,
                        bean!!.status,Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<InsertResponseBean>, t: Throwable) {

                }
            })


        }

        read.setOnClickListener {

            var call = api.read()
            call.enqueue(object : Callback<ReadResponseBean> {

                override fun onResponse(call: Call<ReadResponseBean>, response: Response<ReadResponseBean>) {
                var bean = response.body()
                var list = bean!!.results
                var temp_list = mutableListOf<String>()
                for(item in list!!)
                {
                    temp_list.add(item.name+"\t"+item.gender+"\n"+
                                    item.qual+"\t"+item.yop)
                }

                    var adapter = ArrayAdapter<String>(this@MainActivity,
                            android.R.layout.simple_list_item_single_choice,temp_list)
                    lview.adapter = adapter

                }

                override fun onFailure(call: Call<ReadResponseBean>, t: Throwable) {
                }

            })

        }

    }
}
