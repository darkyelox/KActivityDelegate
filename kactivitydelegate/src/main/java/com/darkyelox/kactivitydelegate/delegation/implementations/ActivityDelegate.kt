@file:Suppress("LeakingThis")

package com.darkyelox.kactivitydelegate.delegation.implementations

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.ActionMode
import com.darkyelox.kactivitydelegate.ActivityDelegation
import com.darkyelox.kactivitydelegate.DelegatedActivityInterface
import com.darkyelox.kactivitydelegate.delegation.definitions.*
import com.darkyelox.kactivitydelegate.extensions.*

/**
 * Created by diego on 30/10/17.
 *
 * @author diego
 */

/**
 * Implementations of [ActivityDelegate1], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl1 : ActivityDelegate1 {
    override lateinit var delegate1: ActivityDelegation

    init {
        delegate1 = delegate()
    }

    val activity by lazy {
        delegate1.activity
    }

    val delegate by lazy {
        delegate1
    }

    abstract fun delegate(): ActivityDelegation
}

/**
 * Implementations of [ActivityDelegate2], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl2 : ActivityDelegate2 {
    override lateinit var delegate2: ActivityDelegation

    init {
        delegate2 = delegate()
    }

    val activity by lazy {
        delegate2.activity
    }

    val delegate by lazy {
        delegate2
    }

    abstract fun delegate(): ActivityDelegation
}

/**
 * Implementations of [ActivityDelegate3], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl3 : ActivityDelegate3 {
    override lateinit var delegate3: ActivityDelegation

    init {
        delegate3 = delegate()
    }

    val activity by lazy {
        delegate3.activity
    }

    val delegate by lazy {
        delegate3
    }

    abstract fun delegate(): ActivityDelegation

}

/**
 * Implementations of [ActivityDelegate4], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl4 : ActivityDelegate4 {
    override lateinit var delegate4: ActivityDelegation

    init {
        delegate4 = delegate()
    }

    val activity by lazy {
        delegate4.activity
    }

    val delegate by lazy {
        delegate4
    }

    abstract fun delegate(): ActivityDelegation

}

/**
 * Implementations of [ActivityDelegate5], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl5 : ActivityDelegate5 {
    override lateinit var delegate5: ActivityDelegation

    init {
        delegate5 = delegate()
    }

    val activity by lazy {
        delegate5.activity
    }

    val delegate by lazy {
        delegate5
    }

    abstract fun delegate(): ActivityDelegation

}

/**
 * Implementations of [ActivityDelegate6], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl6 : ActivityDelegate6 {
    override lateinit var delegate6: ActivityDelegation

    init {
        delegate6 = delegate()
    }

    val activity by lazy {
        delegate6.activity
    }

    val delegate by lazy {
        delegate6
    }

    abstract fun delegate(): ActivityDelegation

}

/**
 * Implementations of [ActivityDelegate7], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl7 : ActivityDelegate7 {
    override lateinit var delegate7: ActivityDelegation

    init {
        delegate7 = delegate()
    }

    val activity by lazy {
        delegate7.activity
    }

    val delegate by lazy {
        delegate7
    }

    abstract fun delegate(): ActivityDelegation

}

/**
 * Implementations of [ActivityDelegate8], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl8 : ActivityDelegate8 {
    override lateinit var delegate8: ActivityDelegation

    init {
        delegate8 = delegate()
    }

    val activity by lazy {
        delegate8.activity
    }

    val delegate by lazy {
        delegate8
    }

    abstract fun delegate(): ActivityDelegation

}

/**
 * Implementations of [ActivityDelegate9], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl9 : ActivityDelegate9 {
    override lateinit var delegate9: ActivityDelegation

    init {
        delegate9 = delegate()
    }

    val activity by lazy {
        delegate9.activity
    }

    val delegate by lazy {
        delegate9
    }

    abstract fun delegate(): ActivityDelegation

}

/**
 * Implementations of [ActivityDelegate10], this ensures not to override the variables of the interface
 * in each inherited class, also brings a common [activity] and [delegate] properties for access
 * the original activity and delegate.
 */
@Suppress("UNUSED")
abstract class ActivityDelegateImpl10 : ActivityDelegate10 {
    override lateinit var delegate10: ActivityDelegation

    init {
        delegate10 = delegate()
    }

    val activity by lazy {
        delegate10.activity
    }

    val delegate by lazy {
        delegate10
    }

    abstract fun delegate(): ActivityDelegation

}


abstract class DelegatedActivity: Activity(), DelegatedActivityInterface<Activity> {
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
