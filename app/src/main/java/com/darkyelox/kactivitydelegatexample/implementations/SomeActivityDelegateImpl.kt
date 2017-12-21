package com.darkyelox.kactivitydelegatexample.implementations

import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.util.Log
import com.darkyelox.kactivitydelegate.AppCompatActivityDelegation
import com.darkyelox.kactivitydelegate.delegation.implementations.AppCompatActivityDelegateImpl1
import com.darkyelox.kactivitydelegatexample.definitions.SomeActivityDelegate
import com.darkyelox.kactivitydelegate.ActivityDelegateImpl
import com.darkyelox.kactivitydelegatexample.R

/**
 * Created by diego on 19/12/17.
 *
 * Class for define the implementation of [SomeActivityDelegate] interface and the logic for this delegation;
 * here we can use Android Activity lifecycle methods or callbacks defined in [ActivityDelegateImpl] and you can access
 * activity directly using the [ActivityDelegateImpl.activity] property.
 *
 * @author diego
 */
class SomeActivityDelegateImpl: AppCompatActivityDelegateImpl1(), SomeActivityDelegate {
    companion object {
        val TAG: String = SomeActivityDelegateImpl::class.java.simpleName
    }

    /**
     * Here we define the Activity delegate as we are defining a normal Android Activity,
     * we can override methods of onCreate, onResume, onDestroy, etc.
     *
     * Also we can access the real activity using the property [ActivityDelegateImpl.activity]
     */
    override fun delegate(): AppCompatActivityDelegation {
        return object: AppCompatActivityDelegation(){
            override fun onResume() {
                super.onResume()
                someActionOn()
            }
        }
    }

    /**
     * We can implement interface methods for use in the real activity
     */
    override fun someActionOn() {
        Log.d(TAG, "Some Action ON")
        this.activity.findViewById<ConstraintLayout>(R.id.content_layout).setBackgroundColor(Color.GREEN)
    }

    override fun someActionOff() {
        Log.d(TAG, "Some Action ON")
        this.activity.findViewById<ConstraintLayout>(R.id.content_layout).setBackgroundColor(Color.WHITE)
    }

}