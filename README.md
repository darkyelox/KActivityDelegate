# KActivityDelegate
A Simple Android library that allows delegate several implementations with own lifecycle to the same Activity without inheritance

This Library allow create several common or reusable logics for your Activities using Kotlin class delegations and maintain the Activity lifecycle and callbacks, this means that you can create a separete class file that do some work in the onCreate, onResume, onDestroy, etc and apply to an Activity class without the need of inheriting from the class and repeat this process several times in the same Activity class.

## How to use

In this section i will explain the use with a simple implementation in which we will change the background color of an activity through a separate file using a `ToggleButton`

So first we create the actions or behavior of our implementation using an interface:

```kotlin
interface SomeActivityDelegate: AppCompatActivityDelegate1 {

    fun someActionOn()
    fun someActionOff()
}
```
