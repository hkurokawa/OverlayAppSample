package com.example.hiroshi.overlayappsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(com.example.hiroshi.overlayappsample.R.layout.activity_main);
  }

  public void onLaunchInspectorClick(View view) {
    Intent intent = InspectorService.newIntent(this);
  }
}
