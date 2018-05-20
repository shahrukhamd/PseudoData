# PseudoData
A sample Android project using the pseudo data from https://jsonplaceholder.typicode.com/ to show some usage of popular libraries and desgin patterns.

# Dependencies
- [RxJava2](https://github.com/ReactiveX/RxJava) - Reactive programming in Android.
- [RxAndroid](https://github.com/ReactiveX/RxAndroid) - Android specific binding for RxJava2.
- [RxJava2 Adapter](https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava2) - An adapter for Retrofit, adapting RxJava 2.x types.
- [Dagger2](https://google.github.io/dagger/) - Static, compile-time, annotation based dependency injection for Android.
- [Retrofit2](http://square.github.io/retrofit/) - REST Client for Android and Java.
- [ButterKnife](http://jakewharton.github.io/butterknife/) - View injection with annotation processing to remove boilerplate code.
- [Glide](https://bumptech.github.io/glide/) -  Fast and efficient image loading.
- [Okhttp3 Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) - An OkHttp interceptor which logs HTTP request and response data (used with Retrofit).
- [Gson](https://github.com/google/gson) - To convert Java objects to JSON and back (used with Retrofit).
- [Timber](https://github.com/JakeWharton/timber) - Logger with a small, extensible API providing utility on top of Android's normal Log class.
- [Constraint Layout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout) - Building complex responsive layouts with performance efficiency.
- [RecyclerView](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html) - Much better list.
- [CardView](https://developer.android.com/reference/android/support/v7/widget/CardView.html) - Just something I like.


# About
The project is about the demonstration of **MVP architecture** and usage of some popular libraries.

The app is **divided into different fragments**, each of which uses a different approach to solve the same problem (fetch, parse and show the data from an API).

- [PostListFragment](https://github.com/shahrukhamd/PseudoData/blob/master/app/src/main/java/com/sasiddiqui/pseudodata/presentation/ui/fragment/PostListFragment.java) is about the demonstration of **MVP (Model-View-Presenter) clean-architecture** which decouple code into different easy-to-manage layers thereby improving code **flexibility and greatly reducing maintenance time**.

- [TodoListFragment](https://github.com/shahrukhamd/PseudoData/blob/master/app/src/main/java/com/sasiddiqui/pseudodata/presentation/ui/fragment/TodoListFragment.java) is just about the usage of some **reactive programming with RxJava2**. It uses **Retrofit2 coupled with RxJava2** and consumes the data from an API.

- [PhotoListFragment](https://github.com/shahrukhamd/PseudoData/blob/master/app/src/main/java/com/sasiddiqui/pseudodata/presentation/ui/fragment/PhotoListFragment.java) is all about the concept of **dependency injection using the Dagger2** library and its implementation in Android. It fetches the data from API with Retrofit2 and **Glide** helps in rendering the images.

# License

    MIT License

    Copyright (c) 2018 Shahrukh Ahmed Siddiqui

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
