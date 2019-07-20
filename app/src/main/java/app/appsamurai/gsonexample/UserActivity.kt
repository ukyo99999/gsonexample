package app.appsamurai.gsonexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken

/**
 * Created by Ukyo on 2019-07-20.
 *
 */
class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/users/1"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                Log.i("response", response.toString())

                try {
                    val gson = Gson()
                    val type = object : TypeToken<UserGson>() {}.type
                    val user = gson.fromJson<UserGson>(response, type)
                    Log.d("user.name", user.name)

                } catch (e: JsonParseException) {
                    Log.e("Gson JsonParseException", e.toString())
                }
            },
            Response.ErrorListener { error ->
                Log.e("error", error.toString())
            })

        queue.add(stringRequest)
    }
}