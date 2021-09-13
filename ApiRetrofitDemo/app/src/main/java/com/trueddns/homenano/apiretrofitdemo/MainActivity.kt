package com.trueddns.homenano.apiretrofitdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.trueddns.homenano.apiretrofitdemo.model.Post
import com.trueddns.homenano.apiretrofitdemo.repository.Repository

//https://www.youtube.com/watch?v=sBCE_hOFnQU&list=PLSrm9z4zp4mF1Ssdfuocy2XH5Bw4wLLNw&index=1


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    val textView: TextView by lazy {
        findViewById(R.id.textView)
    }

    val button: Button by lazy {
        findViewById(R.id.button)
    }

    val editTextNumber: EditText by lazy {
        findViewById(R.id.editTextNumber)
    }

    val nextButton: Button by lazy {
        findViewById(R.id.nextButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // @GET("posts/1")
//        val repository = Repository()
//        val viewModelFactory = MainViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        viewModel.getPost()
//        viewModel.myResponse2.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Response", response.body()?.userId.toString())
//                Log.d("Response", response.body()?.id.toString())
//                Log.d("Response", response.body()?.title!!)
//                Log.d("Response", response.body()?.body!!)
//                textView.text = response.body()?.title!!
//            }else {
//                Log.e("Error", response.errorBody().toString())
//                Log.e("Error", response.code().toString())
//                textView.text = response.code().toString()
//            }
//        })

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        // @POST
//        var myPost = Post(2,2, "Stevdza-San", "Android Developer")
//        viewModel.pushPost(myPost)
//        viewModel.myResponse.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Main", response.body().toString())
//                Log.d("Main", response.code().toString())
//                Log.d("Main", response.message())
//            }else {
//                Log.e("Error", response.errorBody().toString())
//                Log.e("Error", response.code().toString())
//                textView.text = response.code().toString()
//            }
//        })

        // @POST2
//        viewModel.pushPost2(2, 2, "Stevdza", "Android")
//        viewModel.myResponse.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Main", response.body().toString())
//                Log.d("Main", response.code().toString())
//                Log.d("Main", response.message())
//            }else {
//                Log.e("Error", response.errorBody().toString())
//                Log.e("Error", response.code().toString())
//                textView.text = response.code().toString()
//            }
//        })

        // @Get Header
        viewModel.getPost("1111222")
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.headers().toString() )
            }else {
                Log.e("Error", response.errorBody().toString())
                Log.e("Error", response.code().toString())
                textView.text = response.code().toString()
            }
        })



        // @GET("posts/{postNumber}")
//        button.setOnClickListener {
//            val myNumber: String = editTextNumber.text.toString()
//            viewModel.getPost2(Integer.parseInt(myNumber))
//            viewModel.myResponse2.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    textView.text = response.body().toString()
//                } else {
//                    textView.text = response.code().toString()
//                }
//            })
//        }

        // @GET("posts")
//        button.setOnClickListener {
//            val myNumber: String = editTextNumber.text.toString()
//            viewModel.getCustomPosts(Integer.parseInt(myNumber), "id", "asc")
//            viewModel.myCustomPosts.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    textView.text = response.body().toString()
//                    response.body()?.forEach {
//                        Log.d("Response", it.userId.toString())
//                        Log.d("Response", it.id.toString())
//                        Log.d("Response", it.title)
//                        Log.d("Response", it.body)
//                        Log.d("Response", "------------------")
//                    }
//                }else {
//                    textView.text = response.body().toString()
//                }
//            })
//        }

        // Options
//        val options: HashMap<String, String> = HashMap()
//        options["_sort"] = "id"
//        options["_order"] = "desc"
//
//        button.setOnClickListener {
//            val myNumber: String = editTextNumber.text.toString()
//            viewModel.getCustomPosts2(Integer.parseInt(myNumber), options )
//            viewModel.myCustomPosts2.observe(this, Observer { response ->
//                if (response.isSuccessful) {
//                    textView.text = response.body().toString()
//                    response.body()?.forEach {
//                        Log.d("Response", it.userId.toString())
//                        Log.d("Response", it.id.toString())
//                        Log.d("Response", it.title)
//                        Log.d("Response", it.body)
//                        Log.d("Response", "------------------")
//                    }
//                }else {
//                    textView.text = response.body().toString()
//                }
//            })
//        }

        // NextButton
        nextButton.setOnClickListener {
            val intent = Intent(this, RecycleViewActivity::class.java)
            startActivity(intent)
        }



    }
}