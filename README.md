# KActivityDelegate
A Simple Android library that allows delegate several implementations with own lifecycle to the same Activity without inheritance

This Library allow create several common or reusable logics for your Activities using Kotlin class delegations and maintain the Activity lifecycle and callbacks, this means that you can create a separete class file that do some work in the onCreate, onResume, onDestroy, etc and apply to an Activity class without the need of inheriting from the class and repeat this process several times in the same Activity class.

## How to use

In this section i will explain the use with a simple implementation in which we will change the background color of an activity through a separate file using a `ToggleButton`

### Defining Delegate Interface

So first we create the actions or behavior of our implementation using an interface:

```kotlin
interface SomeActivityDelegate: AppCompatActivityDelegate1 {

    fun someActionOn()
    fun someActionOff()
}
```
### Creating implementation of Delegate

Next we define the implementation, in this we can use some of the activity lifecycles or callback methods:

```kotlin
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
```
We implements the `SomeActivityDelegate` interface and extends from `AppCompatActivityDelegateImpl1` this determines that our target activity will be an `AppCompatActivity` and force us to override the abstract method `delegate()` which must return an instance of `AppCompatActivityDelegation`

`AppCompatActivityDelegation` is an interface that allow us to define the lifecycle and callbacks methods from an Android Activities classes so our onCreate method will be called automatically after the onCreate method of the target Activity.

>They are Delegation for `Actity`, `AppCompatActivity` and `FragmentActivity` and each one has an interface and an implementation, so for activities they are an `ActivityDelegate1` interface and an `ActivityDelegateImpl1` implementation and so on 

Notice that we are overriding the `onResume()` method and call the `someActionOn()` method for changing the background color of the target activity

>For now the delegations supports the methods:
*  
