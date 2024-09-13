package com.eosdev.linguallexicon.ui.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eosdev.linguallexicon.R

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.settings_container, CategoryFragment())
                .commit()
        }
    }
}
