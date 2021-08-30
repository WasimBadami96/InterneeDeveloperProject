package base.image.practicingproject

import android.app.Application
import com.google.firebase.FirebaseApp

class AppMain : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}