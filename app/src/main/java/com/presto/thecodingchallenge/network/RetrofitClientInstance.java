package com.presto.thecodingchallenge.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>A retrofit client to call Flicker API with required initialization parameter.</p>
 */
public class RetrofitClientInstance {

  private static Retrofit retrofit;
  private static final String BASE_URL = "https://api.flickr.com/services/";

  /**
   * <p>A method to retrieve retrofit object instance class which required provided build
   * paramter</p>
   *
   * @return @{@link Retrofit} object instance
   */
  public static Retrofit getRetrofitInstance() {
    if (retrofit == null) {
      retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }
}
