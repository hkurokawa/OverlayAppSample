package com.example.hiroshi.overlayappsample;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

final class InspectorService extends Service {
  private boolean running;
  private InspectorSession inspectorSession;

  static Intent newIntent(Context context) {
    return new Intent(context, InspectorService.class);
  }

  @Override public int onStartCommand(Intent intent, int flags, int startId) {
    if (running) {
      return START_NOT_STICKY;
    }
    running = true;

    inspectorSession = new InspectorSession(this);
    inspectorSession.showOverlay();

    return START_NOT_STICKY;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    inspectorSession.destroy();
  }

  @Nullable @Override public IBinder onBind(Intent intent) {
    throw new AssertionError("Not supported.");
  }
}
