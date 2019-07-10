package app.appsamurai.gsonexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/users"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                Log.i("response", response.toString())
            },
            Response.ErrorListener { error ->
                Log.e("ErrorListener", error.toString())
            })

        queue.add(stringRequest)
    }

}
