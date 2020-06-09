package com.example.proyectofinal.alarma

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentAlarmaBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class Alarma : Fragment() {



    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAlarmaBinding>(
            inflater,
            R.layout.fragment_alarma, container, false)

        binding.bpill.setOnClickListener {
            val cal = Calendar.getInstance()

            cal.get(Calendar.YEAR)
            cal.get(Calendar.MONTH)
            cal.get(Calendar.DAY_OF_MONTH)

            val timeSetListener = TimePickerDialog.OnTimeSetListener{
                    _: TimePicker?, hourOfDay: Int, minute: Int ->
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
                cal.set(Calendar.MINUTE, minute)
                cal.set(Calendar.SECOND, 0)
                val time = SimpleDateFormat("HH:mm").format(cal.time)

                Toast.makeText(activity, "Alarma establecida: $time", Toast.LENGTH_SHORT).show()
                setAlarm()

            }
            TimePickerDialog(activity, timeSetListener, cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true).show()
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)
    }

    private fun setAlarm() {
        val alarmManager =
            context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyAlarm::class.java)
        val pi = PendingIntent.getBroadcast(context, 0, intent, 0)
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_DAY, pi)
    }

    //private val CHANNEL_ID = "NOTIFICATION"
    //private val NOTIFICATION_ID = 0

    /*private fun notification() {
        val builder = NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
        builder.setSmallIcon(R.drawable.ic_launcher_background)
        builder.setContentTitle("DRINK ME")
        builder.setContentText("Hora de tomar tu medicamento")
        builder.color = Color.MAGENTA
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setVibrate(longArrayOf(1000, 1000, 1000))
        builder.setDefaults(Notification.DEFAULT_SOUND)
        val notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext())
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build())
    }*/
}
