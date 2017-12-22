# KActivityDelegate
A Simple Android library that allows delegate several implementations with own lifecycle to the same Activity without inheritance

This Library allow create several common or reusable logics for your Activities using Kotlin class delegations and maintain the Activity lifecycle and callbacks, this means that you can create a separete class file that do some work in the onCreate, onResume, onDestroy, etc and apply to an Activity class without the need of inheriting from the class and repeat this process several times in the same Activity class.

## How to use

In this section i will explain the use with a simple implementation in which we will change the background color of an activity through a separate file and trigger the action using a `ToggleButton` in the target Activity

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
        Log.d(TAG, "Some Action OFF")
        this.activity.findViewById<ConstraintLayout>(R.id.content_layout).setBackgroundColor(Color.WHITE)
    }

}
```
We implements the `SomeActivityDelegate` interface and extends from `AppCompatActivityDelegateImpl1` this determines that our target activity will be an `AppCompatActivity` and force us to override the abstract method `delegate()` which must return an instance of `AppCompatActivityDelegation`

`AppCompatActivityDelegation` is an interface that allow us to define the lifecycle and callbacks methods from an Android Activities classes so our onCreate method will be called automatically after the onCreate method of the target Activity.

>They are Delegation for `Actity`, `AppCompatActivity` and `FragmentActivity` and each one has an interface and an implementation, so for activities they are an `ActivityDelegate1` interface and an `ActivityDelegateImpl1` implementation and so on

Notice that we are overriding the `onResume()` method and call the `someActionOn()` method for changing the background color of the target activity

### Creating another delegation and implementation

For example purpouse we create another delegation as follows:

```kotlin
interface OtherActivityDelegate: AppCompatActivityDelegate2 {
    fun otherActionOn()
    fun otherActionOff()
}
```
You can see that this time we use `AppCompatActivityDelegate2` instead of `AppCompatActivityDelegate1` this is needed for using several delegations in the same Activity, you can see them like an ordered delegation where the first one is most used and next are less used or barely used; next we define the implementation for this interface:

```kotlin
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
        Log.d(TAG, "Other Action OFF")
        with(activity) {
            (findViewById<TextView>(R.id.text_view)).text = resources.getString(R.string.original_example_text)
        }
    }
}
```

Also as we are using `AppCompatActivityDelegate2` so we must extends to `AppCompatActivityDelegateImpl2`, this time this implementation changes the text of a TextView in the target Activity (We asume than always will be the same target Activity but obviosly you can think your delegations as a more generic form, this is only an example)

### Using delegations in the target Activity

Finally we will use the delegations, for that we must extends the Activity to `DelegatedAppCompatActivity` and implements the two interfaces for each delegation and by each interface delegates its implementation:

```kotlin
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
```

So in our MainActivity we use some logic for call each delegation logic using a ToogleButton but the good part is that when the Activity starts whe `OnResume` method is called in each delegation implementation so the activity will changes in color and text and when the user toggles the buttons.

### Considerations

When using delegations you must be consistent and use the same type of definition, implementation and target Activity delegate, so you must see the next table for a more clear explanation:

|definition (interface)|implementation|delegated activity|
|---|---|---|
|AppCompatActivityDelegate1...10|AppCompatActivityDelegateImpl1...10|DelegatedAppCompatActivity|
|FragmentActivityDelegate1...10|FragmentActivityDelegateImpl1...10|DelegatedFragmentActivity|
|ActivityDelegate1...10|ActivityDelegateImpl1...10|DelegatedActivity|

For now the `AppCompatActivityDelegation`, `FragmentActivityDelegation` and `ActivityDelegation` support the following Activity lifecycle and callback methods:

+ `onCreate()`
+ `onStart()`
+ `onRestart()`
+ `onResume()`
+ `onPause()`
+ `onStop()`
+ `onDestroy()`
+ `onNewIntent()`
+ `onActivityResult()`
+ `onAttachFragment()`
+ `onActionModeStarted()`
+ `onActionModeFinished()`
+ `onActivityReenter()`

Next development will support more or all Activity callback methods.

At this time we can use a max up to 10 delegations per Activity, i think is an adequate number, so you can define delegations from `AppCompatActivityDelegate1`, `AppCompatActivityDelegate2`, `AppCompatActivityDelegate3`, ... `AppCompatActivityDelegate10` and its implementation for `AppCompatActivityDelegateImpl1`, `AppCompatActivityDelegateImpl2`, `AppCompatActivityDelegateImpl3`, ... `AppCompatActivityDelegateImpl10`

>Remember, there are delegations for `AppCompatActivity`, `FragmentActivity` and `Activity` classes for example there is an `FragmentActivityDelegate5` and `FragmentActivityDelegateImpl5` and so on

>Remember, you can access the target activity using the property `activity` from the implementation class