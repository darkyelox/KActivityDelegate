package com.darkyelox.kactivitydelegatexample.implementations

import android.annotation.SuppressLint
import android.util.Log
import android.widget.TextView
import com.darkyelox.kactivitydelegate.ActivityDelegateImpl
import com.darkyelox.kactivitydelegate.AppCompatActivityDelegation
import com.darkyelox.kactivitydelegate.delegation.implementations.AppCompatActivityDelegateImpl2
import com.darkyelox.kactivitydelegatexample.R
import com.darkyelox.kactivitydelegatexample.definitions.OtherActivityDelegate

/**
 * Created by diego on 19/12/17.
 * Class for define the implementation of [OtherActivityDelegate] interface and the logic for this delegation;
 * here we can use Android Activity lifecycle methods or callbacks defined in [ActivityDelegateImpl] and you can access
 * activity directly using the [ActivityDelegateImpl.activity] property.
 * @author diego
 */
class OtherActivityDelegateImpl: AppCompatActivityDelegateImpl2(), OtherActivityDelegate {
    companion object {
        val TAG: String = OtherActivityDelegateImpl::class.java.simpleName
    }

    /**
     * Here we define the Activity delegate as we are defining a normal Android Activity,
     * we can override methods of onCreate, onResume, onDestroy, etc.
     *
     * Also we can access the real activity using the property [ActivityDelegateImpl.activity]
     */
    override fun delegate(): AppCompatActivityDelegation {
        return object: AppCompatActivityDelegation() {

            override fun onResume() {
                super.onResume()
                otherActionOn()
            }
        }
    }

    /**
     * We can implement interface methods for use in the real activity
     */
    @SuppressLint("SetTextI18n")
    override fun otherActionOn() {
        Log.d(TAG, "Other Action ON")
        (this.activity.findViewById<TextView>(R.id.text_view)).text = "Other Activity Delegate changes this text"
    }

    @SuppressLint("SetTextI18n")
    override fun otherActionOff() {
        Log.d(TAG, "Other Action ON")
        with(activity) {
            (findViewById<TextView>(R.id.text_view)).text = resources.getString(R.string.original_example_text)
        }
    }
}