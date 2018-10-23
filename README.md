# TheCodingChallenge
The Coding Challenge is the Android application which retrieve the flicker API response and display it on a UI. This application is developed as a part of knowledge assessment and validation.

### Prerequisites

Following libraries needs to be added into gradle to use it into the project.

* Retrofit : A Type-safe HTTP client
* Gson Converter : A Converter which uses Gson for serialization to and from JSON.
* Picasso 2 OkHttp 3 Downloader : A powerful image downloading and caching library for Android. A OkHttp 3 downloader implementation for Picasso 2
* RecyclerView : A Recyclerview dependency provided to use Recyclerview to display list data
* CardView: A CardView dependency provided to use CardView to display list item in Recyclerview.
    ```
    implementation 'com.squareup.retrofit2:retrofit:2.4.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
    implementation 'com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0'
    implementation 'com.android.support:cardview-v7:27.1.1'
    implementation 'com.android.support:recyclerview-v7:27.1.1'
   ```

### Development
To provide the required functionality in the application, I have followed the MVP architecture design pattern.

<b>Model</b> : The classes in the `model` package which are `FlickerResponse`, `Photo` and `Photos`.

<b>View</b> : The interface classes which in the `view` package which is `RetrieveDataView`

<b>Presenter</b> : The classes in the `presenter` package which are `DataPresenter` and `DataPresenterImpl`

In the application, `DataPresenterImpl` implements `DataPresenter` and provide all the required Java code functionality regardless of UI.
`RetrieveDataView` is implemented by `MainActivity` and update the UI based on the `DataPresenter` implementation.

The reason behind to use MVP pattern is to provide distinguish the Android UI from the native java code implementation and provide loose coupling between Android view and Java code implementation.

### Future Scope

Additionally, in the application, I would like to provide the Dagger2 dependency and pagination implementation to retrieve more data and photos.
