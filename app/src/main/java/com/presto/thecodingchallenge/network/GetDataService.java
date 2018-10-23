package com.presto.thecodingchallenge.network;

import com.presto.thecodingchallenge.model.FlickerResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GetDataService {

  @GET("rest/")
  Call<FlickerResponse> getFlickerData(@QueryMap Map<String, String> params);

}
