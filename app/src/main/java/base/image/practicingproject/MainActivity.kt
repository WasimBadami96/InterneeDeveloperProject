package base.image.practicingproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import base.image.practicingproject.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.setHasFixedSize(true)

        ///FirebaseApp.initializeApp(this)

        val mRef = FirebaseDatabase.getInstance().getReferenceFromUrl(
                "https://practicingproject-edd1a-default-rtdb.asia-southeast1.firebasedatabase.app")
            .child("Fruit/")
        mRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val subjectList: MutableList<FruitBO?> = ArrayList()
                for (postSnapshot in dataSnapshot.children) {
                    try {
                        val subjectBO: FruitBO? = postSnapshot.getValue(FruitBO::class.java)
                        subjectList.add(subjectBO)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                binding.recyclerview.adapter = FruitAdapter(subjectList)
                {
                    Toast.makeText(this@MainActivity,it.name + " " + it.taste,Toast.LENGTH_LONG).show()
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                //toast message when no data exist
                val toast = Toast.makeText(applicationContext, "Data does not exist", Toast.LENGTH_LONG)
                toast.show()
            }
        })
        /*val particles = arrayListOf<FruitBO>(FruitBO("Apple","Meetha"),
            FruitBO("Mango","Yummy"),FruitBO("Mango","Yummy"),
            FruitBO("Mango","Yummy"),FruitBO("Mango","Yummy"),
            FruitBO("Mango","Yummy"),FruitBO("Mango","Yummy"),
            FruitBO("Mango","Yummy"),FruitBO("Mango","Yummy")
        )
       // binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = FruitAdapter(particles
        ){
            Toast.makeText(this@MainActivity,it.name + " " + it.taste,Toast.LENGTH_LONG).show()
        }*/



        var intent = Intent(applicationContext,InsertDataActivity::class.java)
        startActivity(intent)


    }
}