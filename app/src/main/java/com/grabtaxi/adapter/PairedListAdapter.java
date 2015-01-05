package com.grabtaxi.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.grabtaxi.elm327.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 12/12/14
 */
public class PairedListAdapter extends BaseAdapter
{

    private Context mContext;
    private List<BluetoothDevice> mDeviceList;


    public PairedListAdapter(Context context, Set<BluetoothDevice> deviceList)
    {
        this.mContext = context;
        this.mDeviceList = new ArrayList<>(deviceList.size());
        this.mDeviceList.addAll(deviceList);
    }

    @Override
    public int getCount()
    {
        if (mDeviceList == null)
            return 0;
        else
            return mDeviceList.size();
    }

    @Override
    public BluetoothDevice getItem(int position)
    {
        if (mDeviceList == null)
            return null;
        else
            return mDeviceList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_paired_devices, null);
            holder = new ViewHolder();

            holder.tvDeviceName = (TextView) convertView.findViewById(R.id.tvDeviceName);
            holder.tvMacAddress = (TextView) convertView.findViewById(R.id.tvMacAddress);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Add the name and address to an array adapter to show in a ListView
        holder.tvDeviceName.setText(mDeviceList.get(position).getName());
        holder.tvMacAddress.setText(mDeviceList.get(position).getAddress());

        return convertView;
    }

    static class ViewHolder {
        TextView tvDeviceName;
        TextView tvMacAddress;
    }
}
