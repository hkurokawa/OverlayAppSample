package com.example.hiroshi.overlayappsample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class OverlayView extends FrameLayout {
  private final Listener listener;

  public OverlayView(Context context, Listener listener) {
    super(context);
    this.listener = listener;

    inflate(context, com.example.hiroshi.overlayappsample.R.layout.overlay_view, this);
  }

  static View create(Context context, Listener overlayListener) {
    return new OverlayView(context, overlayListener);
  }

  public static ViewGroup.LayoutParams createLayoutParams(Context context) {
    return null;
  }

  interface Listener {
    void onCancel();

    void onCapture();

    void onResize();
  }
}
