package com.presto.thecodingchallenge.view;

import android.content.Context;
import com.presto.thecodingchallenge.model.Photo;
import java.util.List;

public interface RetrieveDataView {

  void showProgress();

  void hideProgress();

  void showErrorDialog(String message, int errorCode);

  void displayData(List<Photo> photoList);

  Context getContext();

}
