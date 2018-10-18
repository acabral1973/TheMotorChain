package es.smartech.themotorchain.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.smartech.domain.Model.Car
import es.smartech.themotorchain.R

class CarsFragment : Fragment() {

    companion object {
        val ARG_PLACES = "ARG_CARS"

        fun newInstance(cars: ArrayList<Car>): CarsFragment {
            val fragment = CarsFragment()
            val arguments = Bundle()

            arguments.putSerializable(ARG_PLACES, cars)
            fragment.arguments = arguments

            return fragment
        }
    }

    private lateinit var carsList : java.util.ArrayList<Car>
    private lateinit var fragmentView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        carsList = arguments?.getSerializable(ARG_PLACES) as java.util.ArrayList<Car>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val fragmentView = inflater.inflate(R.layout.fragment_cars, container, false)

        // Configure Fragment adding cars list

        return fragmentView
    }
}