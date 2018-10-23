package com.presto.thecodingchallenge;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.presto.thecodingchallenge.adapter.FlickerDataAdapter;
import com.presto.thecodingchallenge.model.Photo;
import com.presto.thecodingchallenge.presenter.DataPresenter;
import com.presto.thecodingchallenge.presenter.DataPresenterImpl;
import com.presto.thecodingchallenge.utils.Constants;
import com.presto.thecodingchallenge.view.RetrieveDataView;
import java.util.List;

/**
 * <p>An entry level class of the Application which display the Photo list data based on the @{@link
 * DataPresenter} implementation</p>
 */
public class MainActivity extends AppCompatActivity implements RetrieveDataView {

  private DataPresenter dataPresenter;
  private ProgressDialog progressDialog;
  private RecyclerView recyclerView;
  private FlickerDataAdapter flickerDataAdapter;
  private AlertDialog alertDialog;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = findViewById(R.id.recyclerView);

    dataPresenter = new DataPresenterImpl();
    dataPresenter.setView(MainActivity.this);
  }

  @Override public void showProgress() {
    progressDialog = new ProgressDialog(MainActivity.this);
    progressDialog.setMessage(getResources().getString(R.string.loading));
    progressDialog.show();
  }

  @Override protected void onResume() {
    super.onResume();
    if (flickerDataAdapter == null && !(alertDialog != null && alertDialog.isShowing())) {
      dataPresenter.checkInternetConnection();
    }
  }

  @Override public void hideProgress() {
    if (progressDialog != null) progressDialog.dismiss();
  }

  @Override public void showErrorDialog(String message, final int errorCode) {
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
    alertDialogBuilder.setMessage(message);
    alertDialogBuilder.setPositiveButton(getResources().getString(R.string.ok),
        new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            if (errorCode == 3) {
              dataPresenter.getFlickerData(Constants.FLICKER_RECENT);
            }
          }
        });
    alertDialog = alertDialogBuilder.show();
  }

  @Override public void displayData(List<Photo> photoList) {
    flickerDataAdapter = new FlickerDataAdapter(MainActivity.this, photoList);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(flickerDataAdapter);
  }

  @Override public Context getContext() {
    return MainActivity.this;
  }
}
