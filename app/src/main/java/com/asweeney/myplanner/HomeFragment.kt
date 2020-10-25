package com.asweeney.myplanner

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    @SuppressLint("SetTextI18n")
    fun getTableArray(view: View): Array<Array<TableRow>> {
        val taskTitle0: TableRow = view.findViewById(R.id.task_title0)
        val taskDateLabels0: TableRow = view.findViewById(R.id.task_datelabels0)
        val dates0: TableRow = view.findViewById(R.id.task_dates0)
        val task0 = arrayOf(taskTitle0,taskDateLabels0,dates0)

        val taskTitle1: TableRow = view.findViewById(R.id.task_title1)
        val taskDateLabels1: TableRow = view.findViewById(R.id.task_datelabels1)
        val dates1: TableRow = view.findViewById(R.id.task_dates1)
        val task1 = arrayOf(taskTitle1,taskDateLabels1,dates1)

        val taskTitle2: TableRow = view.findViewById(R.id.task_title2)
        val taskDateLabels2: TableRow = view.findViewById(R.id.task_datelabels2)
        val dates2: TableRow = view.findViewById(R.id.task_dates2)
        val task2 = arrayOf(taskTitle2,taskDateLabels2,dates2)

        val taskTitle3: TableRow = view.findViewById(R.id.task_title3)
        val taskDateLabels3: TableRow = view.findViewById(R.id.task_datelabels3)
        val dates3: TableRow = view.findViewById(R.id.task_dates3)
        val task3 = arrayOf(taskTitle3,taskDateLabels3,dates3)

        val taskTitle4: TableRow = view.findViewById(R.id.task_title4)
        val taskDateLabels4: TableRow = view.findViewById(R.id.task_datelabels4)
        val dates4: TableRow = view.findViewById(R.id.task_dates4)
        val task4 = arrayOf(taskTitle4,taskDateLabels4,dates4)

        val taskTitle5: TableRow = view.findViewById(R.id.task_title5)
        val taskDateLabels5: TableRow = view.findViewById(R.id.task_datelabels5)
        val dates5: TableRow = view.findViewById(R.id.task_dates5)
        val task5 = arrayOf(taskTitle5,taskDateLabels5,dates5)

        return arrayOf(task0,task1,task2,task3,task4,task5)
    }
    fun hideTask(taskTable: TableLayout, num: Int){
        val tasks = getTableArray(taskTable.rootView)
        when (num){
            1 -> {
                tasks[0][0].visibility = View.VISIBLE
                tasks[0][1].visibility = View.VISIBLE
                tasks[0][2].visibility = View.VISIBLE
                
                tasks[1][0].visibility = View.GONE
                tasks[1][1].visibility = View.GONE
                tasks[1][2].visibility = View.GONE
                
                tasks[2][0].visibility = View.GONE
                tasks[2][1].visibility = View.GONE
                tasks[2][2].visibility = View.GONE
                
                tasks[3][0].visibility = View.GONE
                tasks[3][1].visibility = View.GONE
                tasks[3][2].visibility = View.GONE
                
                tasks[4][0].visibility = View.GONE
                tasks[4][1].visibility = View.GONE
                tasks[4][2].visibility = View.GONE
                
                tasks[5][0].visibility = View.GONE
                tasks[5][1].visibility = View.GONE
                tasks[5][2].visibility = View.GONE
            }
            2 -> {
                tasks[0][0].visibility = View.VISIBLE
                tasks[0][1].visibility = View.VISIBLE
                tasks[0][2].visibility = View.VISIBLE

                tasks[1][0].visibility = View.VISIBLE
                tasks[1][1].visibility = View.VISIBLE
                tasks[1][2].visibility = View.VISIBLE

                tasks[2][0].visibility = View.GONE
                tasks[2][1].visibility = View.GONE
                tasks[2][2].visibility = View.GONE

                tasks[3][0].visibility = View.GONE
                tasks[3][1].visibility = View.GONE
                tasks[3][2].visibility = View.GONE

                tasks[4][0].visibility = View.GONE
                tasks[4][1].visibility = View.GONE
                tasks[4][2].visibility = View.GONE

                tasks[5][0].visibility = View.GONE
                tasks[5][1].visibility = View.GONE
                tasks[5][2].visibility = View.GONE
            }
            3 -> {
                tasks[0][0].visibility = View.VISIBLE
                tasks[0][1].visibility = View.VISIBLE
                tasks[0][2].visibility = View.VISIBLE

                tasks[1][0].visibility = View.VISIBLE
                tasks[1][1].visibility = View.VISIBLE
                tasks[1][2].visibility = View.VISIBLE

                tasks[2][0].visibility = View.VISIBLE
                tasks[2][1].visibility = View.VISIBLE
                tasks[2][2].visibility = View.VISIBLE

                tasks[3][0].visibility = View.GONE
                tasks[3][1].visibility = View.GONE
                tasks[3][2].visibility = View.GONE

                tasks[4][0].visibility = View.GONE
                tasks[4][1].visibility = View.GONE
                tasks[4][2].visibility = View.GONE

                tasks[5][0].visibility = View.GONE
                tasks[5][1].visibility = View.GONE
                tasks[5][2].visibility = View.GONE
            }
            4 -> {
                tasks[0][0].visibility = View.VISIBLE
                tasks[0][1].visibility = View.VISIBLE
                tasks[0][2].visibility = View.VISIBLE

                tasks[1][0].visibility = View.VISIBLE
                tasks[1][1].visibility = View.VISIBLE
                tasks[1][2].visibility = View.VISIBLE

                tasks[2][0].visibility = View.VISIBLE
                tasks[2][1].visibility = View.VISIBLE
                tasks[2][2].visibility = View.VISIBLE

                tasks[3][0].visibility = View.VISIBLE
                tasks[3][1].visibility = View.VISIBLE
                tasks[3][2].visibility = View.VISIBLE

                tasks[4][0].visibility = View.GONE
                tasks[4][1].visibility = View.GONE
                tasks[4][2].visibility = View.GONE

                tasks[5][0].visibility = View.GONE
                tasks[5][1].visibility = View.GONE
                tasks[5][2].visibility = View.GONE
            }
            5 -> {
                tasks[0][0].visibility = View.VISIBLE
                tasks[0][1].visibility = View.VISIBLE
                tasks[0][2].visibility = View.VISIBLE

                tasks[1][0].visibility = View.VISIBLE
                tasks[1][1].visibility = View.VISIBLE
                tasks[1][2].visibility = View.VISIBLE

                tasks[2][0].visibility = View.VISIBLE
                tasks[2][1].visibility = View.VISIBLE
                tasks[2][2].visibility = View.VISIBLE

                tasks[3][0].visibility = View.VISIBLE
                tasks[3][1].visibility = View.VISIBLE
                tasks[3][2].visibility = View.VISIBLE

                tasks[4][0].visibility = View.VISIBLE
                tasks[4][1].visibility = View.VISIBLE
                tasks[4][2].visibility = View.VISIBLE

                tasks[5][0].visibility = View.GONE
                tasks[5][1].visibility = View.GONE
                tasks[5][2].visibility = View.GONE
            }
            6 -> {
                tasks[0][0].visibility = View.VISIBLE
                tasks[0][1].visibility = View.VISIBLE
                tasks[0][2].visibility = View.VISIBLE

                tasks[1][0].visibility = View.VISIBLE
                tasks[1][1].visibility = View.VISIBLE
                tasks[1][2].visibility = View.VISIBLE

                tasks[2][0].visibility = View.VISIBLE
                tasks[2][1].visibility = View.VISIBLE
                tasks[2][2].visibility = View.VISIBLE

                tasks[3][0].visibility = View.VISIBLE
                tasks[3][1].visibility = View.VISIBLE
                tasks[3][2].visibility = View.VISIBLE

                tasks[4][0].visibility = View.VISIBLE
                tasks[4][1].visibility = View.VISIBLE
                tasks[4][2].visibility = View.VISIBLE

                tasks[5][0].visibility = View.VISIBLE
                tasks[5][1].visibility = View.VISIBLE
                tasks[5][2].visibility = View.VISIBLE
            }
        }
    }
    private fun getTasks(taskTable: TableLayout, taskNumLbl: TextView){
        val auth = FirebaseAuth.getInstance()
        val db = Firebase.firestore

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_MONTH)
        var date = "$year-$month-$day"

        val uid = auth.currentUser?.uid
        val users = db.collection("users")
        val user = users.whereEqualTo("uid", uid).get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(NewTaskActivity.TAG, "User Retrieved - $document.id")
                    Log.d(NewTaskActivity.TAG, "Getting Tasks for $date")
                    db.collection("users").document(document.id).collection("tasks").whereEqualTo("dueDate", date).limit(6)
                        .get()
                        .addOnSuccessListener { taskDocs ->
                            val tasks = getTableArray(taskTable.rootView)
                            val index: Int = 0
                            for ((index,task) in taskDocs.withIndex()){
                                val taskRow = tasks[index]
                                val resIDTitle: Int = resources.getIdentifier("txt_tasktitle$index", "id", requireContext().packageName)
                                val resIDStart: Int = resources.getIdentifier("txt_taskstart$index", "id", requireContext().packageName)
                                val resIDDue: Int = resources.getIdentifier("txt_taskdue$index", "id", requireContext().packageName)
                                taskRow[0].findViewById<TextView>(resIDTitle).text = task.getString("title")
                                taskRow[2].findViewById<TextView>(resIDStart).text = task.getString("startDate")
                                taskRow[2].findViewById<TextView>(resIDDue).text = task.getString("dueDate")
                                index.plus(1)
                            }
                            when (val count = taskDocs.size()) {
                                0 -> {
                                    taskNumLbl.text = "You have no tasks due today."
                                    taskNumLbl.visibility = View.VISIBLE
                                }
                                1 -> {
                                    taskNumLbl.text = "You have $count task due today."
                                    hideTask(taskTable, count)
                                    taskNumLbl.visibility = View.VISIBLE
                                    taskTable.visibility = View.VISIBLE
                                }
                                else -> {
                                    taskNumLbl.text = "You have $count tasks due today."
                                    hideTask(taskTable, count)
                                    taskNumLbl.visibility = View.VISIBLE
                                    taskTable.visibility = View.VISIBLE
                                }
                            }
                        }
                }
            }
            .addOnFailureListener { exception ->
                Log.w(NewTaskActivity.TAG, "Error getting documents: ", exception)
            }
    }
    private fun updateTasks(view: View){
        val taskNumLbl: TextView = view.findViewById(R.id.txt_welcome)
        val taskTable: TableLayout = view.findViewById(R.id.tbl_tasks)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)

        taskNumLbl.visibility = View.GONE
        taskTable.visibility = View.GONE
        progressBar.visibility = View.VISIBLE

        getTasks(taskTable, taskNumLbl)
        progressBar.visibility = View.GONE

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val newTask: FloatingActionButton = view.findViewById(R.id.btn_newtask)
        newTask.setOnClickListener{
            val intent = Intent(activity, NewTaskActivity::class.java).apply {
            }
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP;
            intent.putExtra("EXIT", true);
            startActivity(intent)
            updateTasks(view)
        }
        updateTasks(view)
        return view
    }

    companion object {
        private const val TAG = "MyPlanner"
    }
}