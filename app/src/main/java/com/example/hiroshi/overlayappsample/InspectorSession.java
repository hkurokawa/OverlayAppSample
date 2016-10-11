package com.example.hiroshi.overlayappsample;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

class InspectorSession {
  private final Context context;
  private final WindowManager windowManager;
  private View overlayView;

  InspectorSession(Context context) {
    this.context = context;
    windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
  }

  void showOverlay() {
    OverlayView.Listener overlayListener = new OverlayView.Listener() {
      @Override public void onCancel() {
        cancelOverlay();
      }

      @Override public void onCapture() {
      }

      @Override public void onResize() {
        windowManager.updateViewLayout(overlayView, overlayView.getLayoutParams());
      }
    };

    overlayView = OverlayView.create(context, overlayListener);
    windowManager.addView(overlayView, OverlayView.createLayoutParams(context));
  }

  private void hideOverlay() {
    if (overlayView != null) {
      windowManager.removeView(overlayView);
      overlayView = null;
    }
  }

  private void cancelOverlay() {
    hideOverlay();
  }

  void destroy() {

  }
}
