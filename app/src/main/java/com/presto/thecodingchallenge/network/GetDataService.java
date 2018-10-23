package com.presto.thecodingchallenge.network;

import com.presto.thecodingchallenge.model.FlickerResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * <p>A Data service interface which contains the methods of API call</p>
 */
public interface GetDataService {

  /**
   * <p>Retrieve data of flicker photo API : "search" and "getRecent"</p>
   * @param params required get parameters to call API
   * @return @{@link FlickerResponse} data
   */
  @GET("rest/")
  Call<FlickerResponse> getFlickerData(@QueryMap Map<String, String> params);

}
