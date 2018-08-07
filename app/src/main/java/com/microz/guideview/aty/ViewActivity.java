package com.microz.guideview.aty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.microz.guideview.R;
import com.microz.guideview.component.MutiComponent;
import com.microz.guideviewlib.Guide;
import com.microz.guideviewlib.GuideBuilder;

/**
 * 创建时间: 2016/08/24 16:58 <br>
 * 作者: zhangbin <br>
 * 描述:
 */
public class ViewActivity extends Activity {
  private LinearLayout ll_nearby, ll_view_group;
  Guide guide;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_guide_view);
    ll_nearby = (LinearLayout) findViewById(R.id.ll_nearby);
    ll_view_group = (LinearLayout) findViewById(R.id.ll_view_group);
    ll_view_group.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(ViewActivity.this, "show", Toast.LENGTH_SHORT).show();
      }
    });
    ll_nearby.post(new Runnable() {
      @Override public void run() {
        showGuideView();
      }
    });
  }

  public void showGuideView() {
    GuideBuilder builder = new GuideBuilder();
    builder.setTargetView(ll_nearby)
        .setFullingViewId(R.id.ll_view_group)
        .setAlpha(150)
        .setHighTargetCorner(20)
        .setHighTargetPadding(10)
        .setOverlayTarget(false)
        .setOutsideTouchable(false);
    builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
      @Override public void onShown() {
      }

      @Override public void onDismiss() {
      }
    });

    builder.addComponent(new MutiComponent());
    guide = builder.createGuide();
    guide.setShouldCheckLocInWindow(true);
    guide.show(this);
  }
}
