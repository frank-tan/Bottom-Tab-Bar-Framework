# Bottom Tab Bar Navigation Framework

Bottom tab bar provides an easy navigation to explore and switch between top-level views in a single tap. This example app provides a backbone for implementing `Bottom Tab Bar Navigation` in Android.

This example app loosely conforms to the bottom navigation specification in [Material Design](https://material.google.com/components/bottom-navigation.html), but allows each tabs to keeps its navigation state. Meaning, the state can persist through navigation between tabs. Developer can choose to reset the state only when user taps on the active tab.

## Implementation
This app uses one activity per tab. Within each tab, it makes use of fragment to keep the navigation state within that activity.
