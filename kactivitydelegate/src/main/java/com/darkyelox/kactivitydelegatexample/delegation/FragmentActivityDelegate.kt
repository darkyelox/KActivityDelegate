@file:Suppress("LeakingThis")

package com.darkyelox.kactivitydelegate.delegation

import android.app.Fragment
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentActivity
import android.view.ActionMode
import com.darkyelox.kactivitydelegate.ActivityDelegate
import com.darkyelox.kactivitydelegate.ActivityDelegateImpl
import com.darkyelox.kactivitydelegate.DelegatedActivityInterface
import com.darkyelox.kactivitydelegate.FragmentActivityDelegation
import com.darkyelox.kactivitydelegate.extensions.*

/**
 * Created by diego on 1/11/17.
 * 
 * @author diego
 */

/**
 * Delegate interface for [FragmentActivity] classes
 */
@Suppress("UNUSED")
interface FragmentActivityDelegate1 : ActivityDelegate {
    var delegate1: ActivityDelegateImpl<FragmentActivity>
}

/**
 * Delegate interface for [FragmentActivity] classes
 */
@Suppress("UNUSED")
interface FragmentActivityDelegate2 : ActivityDelegate {
    var delegate2: ActivityDelegateImpl<FragmentActivity>
}

/**
 * Delegate interface for [FragmentActivity] classes
 */
@Suppress("UNUSED")
interface FragmentActivityDelegate3 : ActivityDelegate {
    var delegate3: ActivityDelegateImpl<FragmentActivity>
}

/**
 * Delegate interface for [FragmentActivity] classes
 */
@Suppress("UNUSED")
interface FragmentActivityDelegate4 : ActivityDelegate {
    var delegate4: ActivityDelegateImpl<FragmentActivity>
}

/**
 * Implementations of [FragmentActivityDelegate1], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class FragmentActivityDelegateImpl1 : FragmentActivityDelegate1 {
    override lateinit var delegate1: FragmentActivityDelegation

    init {
        delegate1 = delegate()
    }

    val activity by lazy {
        delegate1.activity
    }

    val delegate by lazy {
        delegate1
    }

    abstract fun delegate(): FragmentActivityDelegation
}

/**
 * Implementations of [FragmentActivityDelegate2], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class FragmentActivityDelegateImpl2 : FragmentActivityDelegate2 {
    override lateinit var delegate2: FragmentActivityDelegation

    init {
        delegate2 = delegate()
    }

    val activity by lazy {
        delegate2.activity
    }

    val delegate by lazy {
        delegate2
    }

    abstract fun delegate(): FragmentActivityDelegation
}

/**
 * Implementations of [FragmentActivityDelegate3], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 *
 */
@Suppress("UNUSED")
abstract class FragmentActivityDelegateImpl3 : FragmentActivityDelegate3 {
    override lateinit var delegate3: FragmentActivityDelegation

    init {
        delegate3 = delegate()
    }

    val activity by lazy {
        delegate3.activity
    }

    val delegate by lazy {
        delegate3
    }

    abstract fun delegate(): FragmentActivityDelegation
}

/**
 * Implementations of [FragmentActivityDelegate3], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 *
 */
@Suppress("UNUSED")
abstract class FragmentActivityDelegateImpl4 : FragmentActivityDelegate4 {
    override lateinit var delegate4: FragmentActivityDelegation

    init {
        delegate4 = delegate()
    }

    val activity by lazy {
        delegate4.activity
    }

    val delegate by lazy {
        delegate4
    }

    abstract fun delegate(): FragmentActivityDelegation
}

abstract class DelegatedFragmentActivity: FragmentActivity(), DelegatedActivityInterface<FragmentActivity> {
    override var onCreateCallback: () -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize(this)
        onCreateCallback = {
            onCreateDelegate(savedInstanceState)
        }
    }

    override fun onStart() {
        super.onStart()
        onStartDelegate()
    }

    override fun onRestart() {
        super.onRestart()
        onRestartDelegate()
    }

    override fun onResume() {
        super.onResume()
        onResumeDelegate()
    }

    override fun onPause() {
        super.onPause()
        onPauseDelegate()
    }

    override fun onStop() {
        super.onStop()
        onStopDelegate()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDestroyDelegate()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        onNewIntentDelegate(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        onActivityResultDelegate(requestCode, resultCode, data)
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        onAttachFragmentDelegate(fragment)
    }

    override fun onActionModeStarted(mode: ActionMode?) {
        super.onActionModeStarted(mode)
        onActionModeStarted(mode)
    }

    override fun onActionModeFinished(mode: ActionMode?) {
        super.onActionModeFinished(mode)
        onActionModeFinished(mode)
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?){
        super.onActivityReenter(resultCode, data)
        onActivityReenterDelegate(resultCode, data)
    }

    override fun setContentView(@LayoutRes layoutId: Int) {
        super.setContentView(layoutId)
        onCreateCallback()
    }

    override fun <T : ViewDataBinding> setContentViewDataBinding(layoutId: Int): T {
        return DataBindingUtil.setContentView(this, layoutId)
    }
}
