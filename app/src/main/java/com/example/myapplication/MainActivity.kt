package com.example.myapplication


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var retrofitFragment: RetrofitFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitFragment = RetrofitFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_content, retrofitFragment)
            .commit()
//        supportActionBar?.title = "News List"
        supportActionBar?.title = "Movie List"


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === R.id.menu_1) {
            //액티비티 -> 프래그먼트 데이터 전달
            val bundle: Bundle = Bundle()
            bundle.putString("targetDt", "20210101")
            retrofitFragment = RetrofitFragment()
            //액티비티 -> 프래그먼트 데이터 전달
            retrofitFragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_content, retrofitFragment)
                .commit()
        }
        return super.onOptionsItemSelected(item)
    }




//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId === R.id.menu_all) {
//            //액티비티 -> 프래그먼트 데이터 전달
//            val bundle: Bundle = Bundle()
//            bundle.putString("category", "null")
//            retrofitFragment = RetrofitFragment()
//            //액티비티 -> 프래그먼트 데이터 전달
//            retrofitFragment.arguments = bundle
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.activity_content, retrofitFragment)
//                .commit()
//
//        } else if (item.itemId === R.id.menu_health) {
//            val bundle: Bundle = Bundle()
//            bundle.putString("category", "health")
//            retrofitFragment = RetrofitFragment()
//            retrofitFragment.arguments = bundle
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.activity_content, retrofitFragment)
//                .commit()
//        }else if (item.itemId === R.id.menu_sports) {
//            val bundle: Bundle = Bundle()
//            bundle.putString("category", "sports")
//            retrofitFragment = RetrofitFragment()
//            retrofitFragment.arguments = bundle
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.activity_content, retrofitFragment)
//                .commit()
//        }else if (item.itemId === R.id.menu_business) {
//            val bundle: Bundle = Bundle()
//            bundle.putString("category", "business")
//            retrofitFragment = RetrofitFragment()
//            retrofitFragment.arguments = bundle
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.activity_content, retrofitFragment)
//                .commit()
//        }
//        return super.onOptionsItemSelected(item)
//    }
}