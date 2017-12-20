package com.darkyelox.kactivitydelegate.extensions

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.ActionMode
import com.darkyelox.kactivitydelegate.ActivityDelegate
import com.darkyelox.kactivitydelegate.DelegatedActivityInterface
import com.darkyelox.kactivitydelegate.delegation.*

/**
 * Created by diego on 1/11/17.
 *
 * @author diego
 */

private inline fun <reified T : ActivityDelegate> delegateCaller(inter: DelegatedActivityInterface<*>, toCall: (type: T) -> Unit) {
    // try {
        if (inter is T)
            with(inter as T) {
                toCall(inter)
            }
    /*} catch (e: Exception) {
        if (e !is ClassCastException) {
            e.printStackTrace()
            throw e
        }
    }*/
}

/**
 * Function for initialize all the delegates given the activity as context
 *
 * @param activity the target activity for all delegates
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.initialize(activity: T) {

    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.initialize(activity) })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.initialize(activity) })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.initialize(activity) })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.initialize(activity) })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.initialize(activity as AppCompatActivity) })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.initialize(activity as AppCompatActivity) })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.initialize(activity as AppCompatActivity) })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.initialize(activity as AppCompatActivity) })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.initialize(activity as FragmentActivity) })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.initialize(activity as FragmentActivity) })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.initialize(activity as FragmentActivity) })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.initialize(activity as FragmentActivity) })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onCreate] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onCreateDelegate(savedInstanceState: Bundle?) {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onCreate(savedInstanceState) })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onCreate(savedInstanceState) })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onCreate(savedInstanceState) })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onCreate(savedInstanceState) })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onCreate(savedInstanceState) })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onCreate(savedInstanceState) })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onCreate(savedInstanceState) })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onCreate(savedInstanceState) })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onCreate(savedInstanceState) })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onCreate(savedInstanceState) })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onCreate(savedInstanceState) })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onCreate(savedInstanceState) })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onStart] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onStartDelegate() {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onStart() })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onStart() })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onStart() })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onStart() })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onStart() })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onStart() })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onStart() })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onStart() })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onStart() })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onStart() })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onStart() })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onStart() })
    //########### FRAGMENT ACTIVITY ############//
}


/**
 * Function for call the [Activity.onRestart] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onRestartDelegate() {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onRestart() })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onRestart() })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onRestart() })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onRestart() })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onRestart() })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onRestart() })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onRestart() })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onRestart() })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onRestart() })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onRestart() })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onRestart() })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onRestart() })
    //########### FRAGMENT ACTIVITY ############//
}


/**
 * Function for call the [Activity.onResume] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onResumeDelegate() {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onResume() })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onResume() })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onResume() })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onResume() })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onResume() })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onResume() })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onResume() })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onResume() })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onResume() })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onResume() })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onResume() })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onResume() })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onPause] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onPauseDelegate() {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onPause() })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onPause() })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onPause() })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onPause() })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onPause() })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onPause() })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onPause() })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onPause() })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onPause() })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onPause() })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onPause() })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onPause() })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onStop] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onStopDelegate() {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onStop() })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onStop() })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onStop() })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onStop() })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onStop() })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onStop() })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onStop() })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onStop() })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onStop() })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onStop() })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onStop() })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onStop() })
    //########### FRAGMENT ACTIVITY ############//
}


/**
 * Function for call the [Activity.onDestroy] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onDestroyDelegate() {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onDestroy() })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onDestroy() })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onDestroy() })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onDestroy() })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onDestroy() })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onDestroy() })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onDestroy() })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onDestroy() })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onDestroy() })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onDestroy() })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onDestroy() })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onDestroy() })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onNewIntent] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onNewIntentDelegate(intent: Intent?) {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onNewIntent(intent) })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onNewIntent(intent) })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onNewIntent(intent) })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onNewIntent(intent) })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onNewIntent(intent) })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onNewIntent(intent) })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onNewIntent(intent) })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onNewIntent(intent) })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onNewIntent(intent) })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onNewIntent(intent) })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onNewIntent(intent) })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onNewIntent(intent) })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onActivityResult] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onActivityResultDelegate(requestCode: Int, resultCode: Int, data: Intent?) {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onActivityResult(requestCode, resultCode, data) })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onActivityResult(requestCode, resultCode, data) })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onActivityResult(requestCode, resultCode, data) })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onActivityResult(requestCode, resultCode, data) })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onAttachFragment] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onAttachFragmentDelegate(fragment: Fragment?) {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onAttachFragment(fragment) })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onAttachFragment(fragment) })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onAttachFragment(fragment) })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onAttachFragment(fragment) })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onAttachFragment(fragment) })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onAttachFragment(fragment) })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onAttachFragment(fragment) })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onAttachFragment(fragment) })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onAttachFragment(fragment) })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onAttachFragment(fragment) })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onAttachFragment(fragment) })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onAttachFragment(fragment) })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onActionModeStarted] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onActionModeStartedDelegate(mode: ActionMode?) {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onActionModeStarted(mode) })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onActionModeStarted(mode) })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onActionModeStarted(mode) })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onActionModeStarted(mode) })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onActionModeStarted(mode) })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onActionModeStarted(mode) })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onActionModeStarted(mode) })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onActionModeStarted(mode) })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onActionModeStarted(mode) })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onActionModeStarted(mode) })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onActionModeStarted(mode) })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onActionModeStarted(mode) })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onActionModeFinished] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onActionModeFinishedDelegate(mode: ActionMode?) {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onActionModeFinished(mode) })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onActionModeFinished(mode) })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onActionModeFinished(mode) })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onActionModeFinished(mode) })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onActionModeFinished(mode) })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onActionModeFinished(mode) })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onActionModeFinished(mode) })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onActionModeFinished(mode) })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onActionModeFinished(mode) })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onActionModeFinished(mode) })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onActionModeFinished(mode) })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onActionModeFinished(mode) })
    //########### FRAGMENT ACTIVITY ############//
}

/**
 * Function for call the [Activity.onActivityReenter] implementation of all the delegates of current activity
 */
@Suppress("UNUSED")
fun <T : Activity> DelegatedActivityInterface<T>.onActivityReenterDelegate(resultCode: Int, data: Intent?) {
    //################ ACTIVITY ################//
    delegateCaller<ActivityDelegate1>(this, { type -> type.delegate1.onActivityReenter(resultCode, data) })
    delegateCaller<ActivityDelegate2>(this, { type -> type.delegate2.onActivityReenter(resultCode, data) })
    delegateCaller<ActivityDelegate3>(this, { type -> type.delegate3.onActivityReenter(resultCode, data) })
    delegateCaller<ActivityDelegate4>(this, { type -> type.delegate4.onActivityReenter(resultCode, data) })
    //################ ACTIVITY ################//

    //########## APP COMPAT ACTIVITY ###########//
    delegateCaller<AppCompatActivityDelegate1>(this, { type -> type.delegate1.onActivityReenter(resultCode, data) })
    delegateCaller<AppCompatActivityDelegate2>(this, { type -> type.delegate2.onActivityReenter(resultCode, data) })
    delegateCaller<AppCompatActivityDelegate3>(this, { type -> type.delegate3.onActivityReenter(resultCode, data) })
    delegateCaller<AppCompatActivityDelegate4>(this, { type -> type.delegate4.onActivityReenter(resultCode, data) })
    //########## APP COMPAT ACTIVITY ###########//

    //########### FRAGMENT ACTIVITY ############//
    delegateCaller<FragmentActivityDelegate1>(this, { type -> type.delegate1.onActivityReenter(resultCode, data) })
    delegateCaller<FragmentActivityDelegate2>(this, { type -> type.delegate2.onActivityReenter(resultCode, data) })
    delegateCaller<FragmentActivityDelegate3>(this, { type -> type.delegate3.onActivityReenter(resultCode, data) })
    delegateCaller<FragmentActivityDelegate4>(this, { type -> type.delegate4.onActivityReenter(resultCode, data) })
    //########### FRAGMENT ACTIVITY ############//
}