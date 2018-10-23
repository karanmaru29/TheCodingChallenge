package com.presto.thecodingchallenge.view;

import android.content.Context;
import com.presto.thecodingchallenge.MainActivity;
import com.presto.thecodingchallenge.model.Photo;
import java.util.List;

/**
 * <p>A view interface that implemented by @{@link MainActivity} to update the UI based on the
 *
 * @{@link DataPresenter} implementation. </p>
 */
public interface RetrieveDataView {

  /**
   * <p>A method to show the progress dialog</p>
   */
  void showProgress();

  /**
   * <p>A method to hide the progress dialog</p>
   */
  void hideProgress();

  /**
   * <p>A method to show the error alert dialog</p>
   *
   * @param message message to display on alert dialog
   * @param errorCode provide different re-direction based on the error code
   */
  void showErrorDialog(String message, int errorCode);

  /**
   * <p>A method to display the photo list data into recycler view</p>
   */
  void displayData(List<Photo> photoList);

  /**
   * <p>A method to provide class level context used for presenter implementation.</p>
   */
  Context getContext();
}
