package com.asweeney.myplanner

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import java.time.LocalDate
import java.util.*
import com.google.firebase.Timestamp
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.MetadataChanges
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ServerTimestamp
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.type.Date
import org.w3c.dom.Text

class NewTaskActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val auth = FirebaseAuth.getInstance()
        val db = Firebase.firestore

        val submitBtn: Button = findViewById(R.id.btn_addtask)
        val dueDate: TextView = findViewById(R.id.txt_duedate)
        val startDate: TextView = findViewById(R.id.txt_startdate)
        val taskTitle: TextView = findViewById(R.id.txt_newtasktitle)
        val taskDesc: TextView = findViewById(R.id.txt_desc)
        submitBtn.setOnClickListener() {
            if (taskTitle.text.isEmpty())
                taskTitle.error = "Please enter a task title!"
            else
                taskTitle.error = null
            if (startDate.text.isEmpty())
                startDate.error = "Please select a start date!"
            else
                startDate.error = null
            if (dueDate.text.isEmpty())
                dueDate.error = "Please select a due date!"
            else dueDate.error = null

            if (!(taskTitle.text.isEmpty() or startDate.text.isEmpty() or dueDate.text.isEmpty())) {
                //var startDateData:Timestamp =
                ///var dueDateData = LocalDate.parse(dueDate.text)
                val taskEntry = hashMapOf(
                    "title" to taskTitle.text.toString(),
                    "startDate" to startDate.text.toString(),
                    "dueDate" to dueDate.text.toString(),
                    "desc" to taskDesc.text.toString()
                )
                val uid = auth.currentUser?.uid
                val users = db.collection("users")
                val user = users.whereEqualTo("uid", uid).get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            Log.d(TAG, "${document.id} => ${document.data}")
                            db.collection("users").document(document.id).collection("tasks").add(taskEntry)
                                .addOnSuccessListener { documentReference ->
                                    Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
                                    Toast.makeText(applicationContext, "Task Successfully Added", Toast.LENGTH_SHORT).show()
                                    finish()
                                }
                                .addOnFailureListener { e ->
                                    Log.w(TAG, "Error adding document", e)
                                    Toast.makeText(applicationContext, "Task Add Failed", Toast.LENGTH_SHORT).show()
                                    finish()
                                }
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.w(TAG, "Error getting documents: ", exception)
                        Toast.makeText(applicationContext, "Task Add Failed", Toast.LENGTH_SHORT).show()
                        finish()
                    }

            }
        }
        startDate.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    val c = Calendar.getInstance()
                    val year = c.get(Calendar.YEAR)
                    val month = c.get(Calendar.MONTH)
                    val day = c.get(Calendar.DAY_OF_MONTH)
                    val dpd = DatePickerDialog(
                        this,
                        DatePickerDialog.OnDateSetListener { _, yyyy, monthOfYear, dd ->
                            // Display Selected date in TextView
                            val mm = monthOfYear + 1
                            startDate.text = "$yyyy-$mm-$dd"
                        },
                        year,
                        month,
                        day
                    )
                    dpd.show()
                }
                else {
                    if (startDate.text.isEmpty())
                        startDate.error = "Please select a start date!"
                }
            }
        dueDate.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    val c = Calendar.getInstance()
                    val year = c.get(Calendar.YEAR)
                    val month = c.get(Calendar.MONTH)
                    val day = c.get(Calendar.DAY_OF_MONTH)
                    val dpd = DatePickerDialog(
                        this,
                        DatePickerDialog.OnDateSetListener { _, yyyy, monthOfYear, dd ->
                            // Display Selected date in TextView
                            val mm = monthOfYear + 1
                            dueDate.text = "$yyyy-$mm-$dd"
                        },
                        year,
                        month,
                        day
                    )
                    dpd.show()
                }
                else {
                    if (dueDate.text.isEmpty())
                        dueDate.error = "Please select a due date!"
                }
            }
    }
    companion object {
        const val TAG = "MyPlanner"
    }
}