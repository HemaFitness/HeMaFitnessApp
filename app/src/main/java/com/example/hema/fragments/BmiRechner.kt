package com.example.hema.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hema.R
import kotlinx.android.synthetic.main.fragment_bmi_rechner.*

class BmiRechner : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bmi_rechner, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        calculate_btn.setOnClickListener {

            // Check if the height EditText and Weight EditText are not empty
            if (etHeight.text.isNotEmpty() && etWeight.text.isNotEmpty()) {
                val height = (etHeight.text.toString()).toInt()
                val weight = (etWeight.text.toString()).toInt()

                // calculateBMI will return BMI
                val BMI = calculateBMI(height, weight)

                bmi.text = BMI.toString()
                bmi.visibility = View.VISIBLE

                // Text nach der Einteilung der WHO
                if (BMI < 18.5) {
                    status.text = "Untergewicht"
                } else if (BMI >= 18.5 && BMI < 24.9) {
                    status.text = "Normalgewicht"
                } else if (BMI >= 25 && BMI < 29.9) {
                    status.text = "Übergewicht"
                } else if (BMI >= 30 && BMI < 34.9) {
                    status.text = "Adipositas Grad 1"
                } else if (BMI >= 35 && BMI < 39.9) {
                    status.text = "Adipositas Grad 2"
                } else if (BMI >= 40) {
                    status.text = "Adipositas Grad 3"
                }

                bmi_tv.visibility = View.VISIBLE
                status.visibility = View.VISIBLE

                ReCalculate.visibility = View.VISIBLE
                calculate_btn.visibility = View.GONE

            }

            // when either Weight EditText or
            // height EditText have null value
            // we will display toast.
            else {
                Toast.makeText(activity,"Bitte gültige Werte für Größe und Gewicht eintragen!",Toast.LENGTH_SHORT).show();
            }
        }

        ReCalculate.setOnClickListener {
            ResetEverything()
        }

    }

    // Function to reset all Text and EditText fields.
    private fun ResetEverything() {

        calculate_btn.visibility = View.VISIBLE
        ReCalculate.visibility = View.GONE

        etHeight.text.clear()
        etWeight.text.clear()
        status.text = " "
        bmi.text = " "
        bmi_tv.visibility = View.GONE
    }

    // Function for calculating BMI
    private fun calculateBMI(height: Int, weight: Int): Float {

        val Height_in_metre = height.toFloat() / 100
        val BMI = weight.toFloat() / (Height_in_metre * Height_in_metre)

        return BMI
    }
}