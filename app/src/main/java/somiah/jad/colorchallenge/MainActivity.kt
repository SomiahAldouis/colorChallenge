package somiah.jad.colorchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), TextColorFragment.Callbacks  {

    private lateinit var redButton: Button
    private lateinit var greenButton: Button
    private lateinit var yellowButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        redButton = findViewById(R.id.red_button)
        greenButton=findViewById(R.id.green_button)
        yellowButton=findViewById(R.id.yellow_button)


        redButton.setOnClickListener {
            sendColor("RED")
        }
        greenButton.setOnClickListener {
            sendColor("GREEN")
        }
        yellowButton.setOnClickListener {
            sendColor("YELLOW")
        }
    }

    fun sendColor(color: String){
        var currentFragment = supportFragmentManager.findFragmentById(R.id.fragment)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment,TextColorFragment.newInstance(color))
            .commit()
    }
    fun sendName(name: String){
        var currentFragment = supportFragmentManager.findFragmentById(R.id.fragment2)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment2,SecondFragment.newInstance(name))
            .commit()
    }

    override fun onButtonClicked(s: String) {
        sendName("somiah")
    }

}