package com.darkyelox.kactivitydelegatexample

import android.os.Bundle
import android.widget.ToggleButton
import com.darkyelox.kactivitydelegate.delegation.implementations.DelegatedAppCompatActivity
import com.darkyelox.kactivitydelegatexample.definitions.OtherActivityDelegate
import com.darkyelox.kactivitydelegatexample.definitions.SomeActivityDelegate
import com.darkyelox.kactivitydelegatexample.implementations.OtherActivityDelegateImpl
import com.darkyelox.kactivitydelegatexample.implementations.SomeActivityDelegateImpl

/**
 * Main delegated Activity, it extends from [DelegatedAppCompatActivity] and use the delegates implementations
 * [SomeActivityDelegateImpl] and [OtherActivityDelegateImpl] so both delegations can have an Activity
 * Lifecycle and manipulate this activity, this allow us to create a determinate activity logic and apply it
 * to any activity and the best thing "WE CAN CREATE SEVERAL DELEGATES AND APPLY TO THE SAME ACTIVITY WITHOUT
 * THE NEED OF INHERITANCE".
 *
 * This means than we can have an activity delegation in charged of the drawer layout and another in charge of
 * apply some style or functionality, like a logic for ActionBar menu options or the start of certain service or
 * the logic for start other activity and wait for results, etc.
 */
class MainActivity : DelegatedAppCompatActivity(), SomeActivityDelegate by SomeActivityDelegateImpl(), OtherActivityDelegate by OtherActivityDelegateImpl() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ToggleButton>(R.id.some_action_button).setOnCheckedChangeListener { _, checked ->
            if(checked)
                someActionOn()
            else
                someActionOff()
        }

        findViewById<ToggleButton>(R.id.other_action_button).setOnCheckedChangeListener { _, checked ->
            if(checked)
                otherActionOn()
            else
                otherActionOff()
        }
    }
}
