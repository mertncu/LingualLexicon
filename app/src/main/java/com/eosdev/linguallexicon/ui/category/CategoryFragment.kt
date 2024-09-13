package com.eosdev.linguallexicon.ui.category

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import com.eosdev.linguallexicon.R

class CategoryFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val categorySwitches = mapOf(
            R.id.switch_food to "Food",
            R.id.switch_electronics to "Electronics",
            R.id.switch_furniture to "Furniture",
            R.id.switch_home to "Home",
            R.id.switch_clothing to "Clothing",
            R.id.switch_personal_care to "Personal Care",
            R.id.switch_decor to "Decor",
            R.id.switch_tools to "Tools",
            R.id.switch_transportation to "Transportation",
            R.id.switch_kitchen to "Kitchen",
            R.id.switch_stationery to "Stationery",
            R.id.switch_education to "Education"
        )

        categorySwitches.forEach { (switchId, category) ->
            val switchView: Switch = view.findViewById(switchId)
            switchView.isChecked = sharedPreferences.getBoolean(category, true)
            switchView.setOnCheckedChangeListener { _, isChecked ->
                editor.putBoolean(category, isChecked).apply()
            }
        }
    }
}
