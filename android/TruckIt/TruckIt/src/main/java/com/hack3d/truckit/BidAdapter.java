package com.hack3d.truckit;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericwood on 8/24/13.
 */
public class BidAdapter extends ArrayAdapter<Bid> {
    private boolean biddingInProgress = true;
    private List<Bid> bids;
    private String userId;
    private int layoutResourceId;


    public BidAdapter(Context context, int textViewResourceId, List<Bid> bids, String userId) {
        super(context, textViewResourceId, bids);
        this.bids = bids;
        this.userId = userId;
        this.layoutResourceId = textViewResourceId;

        // Kick off an async task to update the data
        new BidUpdateAsyncTask().execute();
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        if ( row == null )
        {
            LayoutInflater inflater = (LayoutInflater) super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, null);

            Bid bid = bids.get(position);

            TextView tvPrice = (TextView)row.findViewById(R.id.tvPrice);
            tvPrice.setText("$" + bid.getPrice());

            TextView tvHaulerName = (TextView)row.findViewById(R.id.tvHaulerName);
            tvHaulerName.setText(bid.getBiddingUser().getHaulerDisplayName());

            RatingBar rbHaulerRating = (RatingBar)row.findViewById(R.id.rbHaulerRating);
//            rbHaulerRating.setRating(bid.getBiddingUser().getHaulerRating());
            rbHaulerRating.setRating(position/1.2f + 3f);

            ImageView ivAccept = (ImageView)row.findViewById(R.id.ivAccept);
            ivAccept.setOnClickListener(new BidAcceptedListener(bid));

        }

        return row;
    }

    private void onAcceptBid(Bid bid) {
        biddingInProgress = false;
    }

    private class BidUpdateAsyncTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<Bid> updatedBids = TruckItClient.getBids(userId);
            bids.clear();
            bids.addAll(updatedBids);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            notifyDataSetChanged();
            if (biddingInProgress) {
                new BidUpdateAsyncTask().execute();
            }
        }
    }

    private class BidAcceptedListener implements View.OnClickListener {
        private Bid acceptedBid;

        public BidAcceptedListener(Bid bid) {
            this.acceptedBid = bid;
        }

        @Override
        public void onClick(View view) {
            onAcceptBid(this.acceptedBid);
            ImageView iv = (ImageView)view;
            iv.setImageResource(R.drawable.edit_finish_select);
        }
    }
}



