package com.presto.thecodingchallenge.presenter;

import com.presto.thecodingchallenge.view.RetrieveDataView;

/**
 * <p>A presenter interface implemented by @{@link DataPresenterImpl} to provide java-code
 * implementation
 * and update the view based on the different UI flows.</p>
 */
public interface DataPresenter {

  /**
   * <p>Sets a view into presenter to update the UI from presenter</p>
   *
   * @param retrieveDataView A view interface
   */
  void setView(RetrieveDataView retrieveDataView);

  /**
   * <p>A method to call the Flicker data API and retrieve the response and handle the success and
   * failure scenario</p>
   */
  void getFlickerData(String methodName);

  /**
   * <p>A method to check the internet connection before calling the flicker API</p>
   */
  void checkInternetConnection();
}
