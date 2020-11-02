package somiah.jad.colorchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.util.stream.IntStream

class TextColorFragment : Fragment() {

    interface Callbacks {
        fun onButtonClicked(s: String)
    }
    private var callbacks: Callbacks? = null

    private lateinit var text_fragment : TextView
    private lateinit var button_activity: Button

    var nameColor: String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nameColor = arguments?.getSerializable("name") as String
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }
    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_text_color, container, false)

        text_fragment = view.findViewById(R.id.text_fragment) as TextView
        button_activity = view.findViewById(R.id.button_activity) as Button
        text_fragment.setText(nameColor)
        button_activity.setOnClickListener {
            callbacks?.onButtonClicked("somiah")
        }

        return view
    }


    companion object {
        fun newInstance(param1: String) =
            TextColorFragment().apply {
                var argument= Bundle().apply {
                    putSerializable("name",param1)
                }

                return TextColorFragment().apply {
                    arguments = argument
                }
            }
    }
}