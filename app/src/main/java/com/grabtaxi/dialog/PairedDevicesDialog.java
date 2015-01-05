package com.grabtaxi.dialog;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.grabtaxi.adapter.PairedListAdapter;
import com.grabtaxi.elm327.R;

/**
 * Created by admin on 12/12/14
 */
public class PairedDevicesDialog extends DialogFragment
{
    public interface PairedDeviceDialogListener
    {
        void onDeviceSelected(BluetoothDevice device);

        void onSearchAroundDevicesRequested();

        void onCancelScanningRequested();
    }

    private PairedDeviceDialogListener mListener;
    private PairedListAdapter mAdapter;

    private boolean isScanningMode = false;

    public PairedDevicesDialog()
    {

    }

    /**
     * Adapter assignment
     *
     * @param adapter
     * @param isScanningMode true if scanning bluetooth is in progress. False otherwise.
     */
    public void setAdapter(PairedListAdapter adapter, boolean isScanningMode)
    {
        this.mAdapter = adapter;
        this.isScanningMode = isScanningMode;
    }

    public PairedListAdapter getAdapter()
    {
        return mAdapter;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        try
        {
            mListener = (PairedDeviceDialogListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " must implement PairedDeviceDialogListener of PairedDevicesDialog class.");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);

        // Assign layout to fragment
        View view = inflater.inflate(R.layout.dialog_paired_devices, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                BluetoothDevice device = mAdapter.getItem(position);
                mListener.onDeviceSelected(device);
                getDialog().dismiss();
            }
        });

        View footerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_footer_search, null, false);
        Button btnSearch = (Button) footerView.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!isScanningMode)
                {
                    mListener.onSearchAroundDevicesRequested();
                }
                else
                {
                    mListener.onCancelScanningRequested();
                }

                getDialog().dismiss();
            }
        });
        listView.addFooterView(footerView);

        // Set title and button's text of dialog
        if (!isScanningMode)
        {
            getDialog().setTitle(getString(R.string.dialog_title_1));
            btnSearch.setText(getString(R.string.dialog_search_btn));
        }
        else
        {
            getDialog().setTitle(getString(R.string.dialog_title_2));
            btnSearch.setText(getString(R.string.dialog_close_btn));
        }

        // Prevent user to close dialog by click on back button (to capture close button)
//        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener()
//        {
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event)
//            {
//                return keyCode == KeyEvent.KEYCODE_BACK;
//            }
//        });

        // prevent the dialog to be canceled
//        getDialog().setCancelable(false);
//        getDialog().setCanceledOnTouchOutside(false);

        return view;
    }

}
