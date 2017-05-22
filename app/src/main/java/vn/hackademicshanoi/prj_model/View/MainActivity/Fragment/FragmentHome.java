package vn.hackademicshanoi.prj_model.View.MainActivity.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import vn.hackademicshanoi.prj_model.R;

/**
 * Created by Admin on 5/19/2017.
 */

public class FragmentHome extends Fragment {

    WebView webView;
    ProgressBar progressHome;
    int kiemtra = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        webView = (WebView) view.findViewById(R.id.webview);
        progressHome = (ProgressBar) view.findViewById(R.id.progressHome);
        progressHome.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient() {

                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                         view.loadUrl(url);
                                         return true;
                                     }



            @Override
                                     public void onPageFinished(WebView view, String url) {
                                         super.onPageFinished(view, url);
                                         progressHome.setVisibility(View.GONE);
                                     }

                                     @Override
                                     public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                                         super.onReceivedError(view, request, error);
                                         Toast.makeText(getActivity(),"Đã xảy ra lỗi",Toast.LENGTH_SHORT).show();
                                     }
                                 }
        );

        webView.loadUrl("http://webview.in-star.jp");



        return view;
    }
}
