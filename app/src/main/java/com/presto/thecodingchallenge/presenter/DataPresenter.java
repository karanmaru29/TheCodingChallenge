package com.presto.thecodingchallenge.presenter;

import com.presto.thecodingchallenge.view.RetrieveDataView;

public interface DataPresenter {

  void setView(RetrieveDataView retrieveDataView);

  void getFlickerData(String methodName);

  void checkInternetConnection();
}
