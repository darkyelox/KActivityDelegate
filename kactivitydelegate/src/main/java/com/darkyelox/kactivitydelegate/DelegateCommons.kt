@file:Suppress("LeakingThis")

package com.darkyelox.kactivitydelegate

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.ActionMode

/**
 * Created by diego on 1/11/17.
 *
 * @author diego
 */

/**
 * Interface for easing function extensions in each delegate instance
 */
interface ActivityDelegate

/**
 * Implementation for the delegated Activity
 */
abstract class ActivityDelegateImpl<T : Activity> {
    lateinit var activity: T

    fun initialize(activity: T) {
        this.activity = activity
    }

    /**
     * @see Activity.onCreate
     */
    open fun onCreate(savedInstanceState: Bundle?) {}

    /**
     * @see Activity.onStart
     */
    open fun onStart() {}

    /**
     * @see Activity.onRestart
     */
    open fun onRestart() {}

    /**
     * @see Activity.onResume
     */
    open fun onResume() {}

    /**
     * @see Activity.onPause
     */
    open fun onPause() {}

    /**
     * @see Activity.onStop
     */
    open fun onStop() {}

    /**
     * @see Activity.onDestroy
     */
    open fun onDestroy() {}

    /**
     * @see Activity.onNewIntent
     */
    open fun onNewIntent(intent: Intent?) {}

    /**
     * @see Activity.onActivityResult
     */
    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    /**
     * @see Activity.onAttachFragment
     */
    open fun onAttachFragment(fragment: Fragment?) {}

    open fun onActionModeStarted(mode: ActionMode?) {}

    open fun onActionModeFinished(mode: ActionMode?) {}

    open fun onActivityReenter(resultCode: Int, data: Intent?) {}
}

/**
 * Interface for all the Delegated Activities
 */
@Suppress("UNUSED")
interface DelegatedActivityInterface<T : Activity> {
    var onCreateCallback: () -> Unit
    fun setContentView(@LayoutRes layoutId: Int)
    fun <T : ViewDataBinding> setContentViewDataBinding(@LayoutRes layoutId: Int): T
}

@Suppress("UNUSED")
typealias ActivityDelegation = ActivityDelegateImpl<Activity>

@Suppress("UNUSED")
typealias AppCompatActivityDelegation = ActivityDelegateImpl<AppCompatActivity>

@Suppress("UNUSED")
typealias FragmentActivityDelegation = ActivityDelegateImpl<FragmentActivity>
