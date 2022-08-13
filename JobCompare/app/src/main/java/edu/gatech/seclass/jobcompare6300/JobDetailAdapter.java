package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.database.model.JobDetail;

public class JobDetailAdapter extends ArrayAdapter<JobDetail> {
    public JobDetailAdapter(Context context, ArrayList<JobDetail> data) {
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JobDetail offer = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.offer_item, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView _id = (TextView) convertView.findViewById(R.id.job_id);
        title.setText(offer.getTitle());
        _id.setText(Integer.toString(offer.getId()));
        return convertView;
    }
}