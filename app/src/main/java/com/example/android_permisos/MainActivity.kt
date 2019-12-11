package com.example.android_permisos

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

const val MY_PERMISSIONS_REQUEST_READ_CALL = 1
const val MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toast = Toast.makeText(applicationContext, " Permission is not granted", 10)


        //Permiso de llamada
        bLlamada.setOnClickListener {
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                )
                != PackageManager.PERMISSION_GRANTED
            ) {

                // Permission is not granted
                toast.setText("No tiene este permiso.")
                toast.show()
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.CALL_PHONE
                    )
                ) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        MY_PERMISSIONS_REQUEST_READ_CALL
                    )

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            } else {
                toast.setText("Ya tiene este permiso.")
                toast.show()
                // Permission has already been granted
            }

        }
        bContactos.setOnClickListener {
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                )
                != PackageManager.PERMISSION_GRANTED
            ) {

                // Permission is not granted
                toast.setText("No tiene este permiso.")
                toast.show()
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.READ_CONTACTS
                    )
                ) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS
                    )

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            } else {
                toast.setText("Ya tiene este permiso.")
                toast.show()
                // Permission has already been granted
            }

        }



    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_CALL -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    longToast(
                        "permission was granted, yay! Do the\n" +
                                "contacts-related task you need to do."
                    )

                } else {

                    longToast(
                        " permission denied, boo! Disable the\n" +
                                "functionality that depends on this permission."
                    )
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }

    }


}