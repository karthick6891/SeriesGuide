
package com.battlelancer.seriesguide.ui;

import com.actionbarsherlock.app.SherlockFragment;
import com.battlelancer.seriesguide.util.Utils;
import com.uwetrottmann.seriesguide.R;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Tells about trakt and how it integrates with SeriesGuide, allows to proceed
 * to entering credentials step.
 */
public class ConnectTraktFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.connect_trakt_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // connect button
        getView().findViewById(R.id.buttonConnectTrakt).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectTraktCredentialsFragment f = ConnectTraktCredentialsFragment.newInstance();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(android.R.id.content, f);
                ft.commit();
            }
        });

        // discard button
        getView().findViewById(R.id.buttonDiscard).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        // make learn more link clickable
        ((TextView) getView().findViewById(R.id.textViewAbout))
                .setMovementMethod(LinkMovementMethod.getInstance());
    }
    
    @Override
    public void onStart() {
        super.onStart();
        Utils.trackView(getActivity(), "Connect Trakt Intro");
    }
}
