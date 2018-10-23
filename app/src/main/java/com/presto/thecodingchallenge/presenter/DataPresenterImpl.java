package com.presto.thecodingchallenge.presenter;

import android.util.Log;
import com.presto.thecodingchallenge.R;
import com.presto.thecodingchallenge.model.FlickerResponse;
import com.presto.thecodingchallenge.model.Photo;
import com.presto.thecodingchallenge.network.GetDataService;
import com.presto.thecodingchallenge.network.RetrofitClientInstance;
import com.presto.thecodingchallenge.utils.Constants;
import com.presto.thecodingchallenge.utils.NetworkUtil;
import com.presto.thecodingchallenge.view.RetrieveDataView;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPresenterImpl implements DataPresenter {

  private RetrieveDataView retrieveDataView;

  @Override public void setView(RetrieveDataView retrieveDataView) {
    this.retrieveDataView = retrieveDataView;
  }

  @Override public void getFlickerData(String methodName) {
    GetDataService service =
        RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

    Map<String, String> params = new HashMap<>();
    params.put(Constants.API_KEY, Constants.API_KEY_VALUE);
    params.put(Constants.METHOD, methodName);
    params.put(Constants.FORMAT, Constants.FORMAT_TYPE);
    params.put(Constants.NOJSON_CALLBACK, Constants.CALLBACK_VALUE);

    retrieveDataView.showProgress();
    Call<FlickerResponse> call = service.getFlickerData(params);
    call.enqueue(new Callback<FlickerResponse>() {
      @Override
      public void onResponse(Call<FlickerResponse> call, Response<FlickerResponse> response) {
        retrieveDataView.hideProgress();
        if (response.body().getCode() != null && response.body().getCode().equals("3")) {
          retrieveDataView.showErrorDialog(response.body().getMessage(),
              Integer.parseInt(response.body().getCode()));
        } else {
          setUrl(response.body());
          retrieveDataView.displayData(response.body().getPhotos().getPhoto());
        }
      }

      @Override public void onFailure(Call<FlickerResponse> call, Throwable t) {
        Log.e("DataPresenterImpl", t.getMessage());
        retrieveDataView.hideProgress();
      }
    });
  }

  @Override public void checkInternetConnection() {
    if(NetworkUtil.isNetworkConnected(retrieveDataView.getContext())){
      getFlickerData(Constants.FLICKER_SEARCH);
    }
    else{
      retrieveDataView.showErrorDialog(retrieveDataView.getContext().getResources().getString(
          R.string.internet_not_available), 0);
    }
  }

  private String generatePhotoUrl(Photo photo) {
    return String.format("https://farm%1$s.staticflickr.com/%2$s/%3$s_%4$s.jpg", photo.getFarm(),
        photo.getServer(), photo.getId(), photo.getSecret());
  }

  private void setUrl(FlickerResponse response) {
    for (int i = 0; i < response.getPhotos().getPhoto().size(); i++) {
      Photo photo = response.getPhotos().getPhoto().get(i);
      photo.setUrl(generatePhotoUrl(photo));
      response.getPhotos().getPhoto().set(i, photo);
    }
  }
}
