package com.hack3d.truckit;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ericwood on 8/24/13.
 */
public class JobAdapter extends ArrayAdapter<Job> {
    private boolean biddingInProgress = true;
    private List<Job> jobs;
    private String userId;
    private int layoutResourceId;


    public JobAdapter(Context context, int textViewResourceId, List<Job> jobs, String userId) {
        super(context, textViewResourceId, jobs);
        this.jobs = jobs;
        this.userId = userId;
        this.layoutResourceId = textViewResourceId;

        // Kick off an async task to update the data
        new RatingUpdateAsyncTask().execute();
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        if ( row == null )
        {
            LayoutInflater inflater = (LayoutInflater) super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, null);

            Job job = jobs.get(position);

            TextView tvPrice = (TextView)row.findViewById(R.id.tvPrice);
            tvPrice.setText("$" + job.getPrice());

            TextView tvHaulerName = (TextView)row.findViewById(R.id.tvHaulerName);
            tvHaulerName.setText(job.getHaulerId());

            RatingBar rbHaulerRating = (RatingBar)row.findViewById(R.id.rbHaulerRating);
//            rbHaulerRating.setNumStars(bid.getBiddingUser().);

            //ImageView ivAccept = (ImageView)row.findViewById(R.id.rbHaulerRating);
            rbHaulerRating.setOnClickListener(new ClickListener(job));

        }

        return row;
    }

    private void onAcceptBid(Bid bid) {
        biddingInProgress = false;
    }

    private class RatingUpdateAsyncTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {

//            TruckItClient.getBids(userId);
//            jobs.clear();
//            jobs.addAll(updatedBids);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            notifyDataSetChanged();
            if (biddingInProgress) {
                new RatingUpdateAsyncTask().execute();
            }
        }
    }

    private class ClickListener implements View.OnClickListener {
        private Job job;

        public ClickListener(Job job) {
            this.job = job;
        }

        @Override
        public void onClick(View view) {
            view.getParent();
            RatingBar bar = (RatingBar) view;

            //TruckItClient.updateJob();

        }
    }
}



