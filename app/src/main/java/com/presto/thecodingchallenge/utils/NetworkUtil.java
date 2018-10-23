package com.presto.thecodingchallenge.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * <p>A Utility class to check the internet connection</p>
 */
public class NetworkUtil {

  /**
   * <p>A method to check the internet connection</p>
   *
   * @param context Class level context paramter
   * @return boolean true : if internet is connected or false : if internet is not connected
   */
  public static boolean isNetworkConnected(Context context) {
    ConnectivityManager connectivityManager =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isConnected()) {
      return true;
    } else {
      return false;
    }
  }
}
