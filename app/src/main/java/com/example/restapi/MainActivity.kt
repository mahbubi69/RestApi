package com.example.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), ItemClikHandler {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataService = RetrofitClient.getDataApi()
        dataService.ambilpost().enqueue(object : Callback<ArrayList<PostRespon>> {
            override fun onResponse(
                call: Call<ArrayList<PostRespon>>,
                response: Response<ArrayList<PostRespon>>
            ) {
                if (response.isSuccessful) {
                    Log.d("data", "${response.body()}")
                    val data1 = response.body()
                    menampilkanRecyclerview(data1!!)
                 } else {
                    Log.e("not succes", "tidak sukses")
                }
            }

            override fun onFailure(call: Call<ArrayList<PostRespon>>, t: Throwable) {
                t.message?.let { Log.e("error", it) }
            }
        })

    }

    fun menampilkanRecyclerview(listdataku: ArrayList<PostRespon>) {
        adapter = DataAdapter(listdataku, this)
        binding.rvData.adapter = adapter
        binding.rvData.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onSpinnerClik(dataResp: PostRespon, action: String) {
        Toast.makeText(this, "test ${dataResp.arti},sudah di $action", Toast.LENGTH_SHORT).show()
    }
}



