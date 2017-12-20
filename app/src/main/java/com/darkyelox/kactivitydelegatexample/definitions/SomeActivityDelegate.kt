package com.darkyelox.kactivitydelegatexample.definitions

import com.darkyelox.kactivitydelegate.delegation.AppCompatActivityDelegate1

/**
 * Created by diego on 19/12/17.
 *
 * Defines an activity delegation interface with methods that can be called by the delegated activity
 *
 * @author diego
 */
interface SomeActivityDelegate: AppCompatActivityDelegate1 {

    fun someActionOn()
    fun someActionOff()
}