package com.darkyelox.kactivitydelegatexample.definitions

import com.darkyelox.kactivitydelegate.delegation.definitions.AppCompatActivityDelegate2

/**
 * Created by diego on 19/12/17.
 *
 * Defines an activity delegation interface with methods that can be called by the delegated activity
 *
 * @author diego
 */
interface OtherActivityDelegate: AppCompatActivityDelegate2 {
    fun otherActionOn()
    fun otherActionOff()
}