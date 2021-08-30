package base.image.practicingproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import base.image.practicingproject.databinding.ActivityInsertDataBinding
import com.google.firebase.database.FirebaseDatabase

class InsertDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInsertDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = FirebaseDatabase.getInstance().reference

        binding.savebtn.setOnClickListener()
        {
            if (binding.edttext1.text !=null && binding.edttext2.text !=null)
            {
                val edt1 = binding.edttext1.text.toString()
                val edt2 = binding.edttext2.text.toString()
            db.child("Fruit/").setValue(FruitBO(edt1,edt2))


            }
            else
            {
                Toast.makeText(this, "Please fill the name and taste of fruits", Toast.LENGTH_SHORT).show()
            }

        }
    }
}