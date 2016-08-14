package com.elpatika.eventadvisor.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elpatika.eventadvisor.R;
import com.elpatika.eventadvisor.core.App;
import com.elpatika.eventadvisor.model.Event;
import com.elpatika.eventadvisor.ui.presenters.EventFeedPresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private EventFeedPresenter eventFeedPresenter;

    public EventsAdapter(EventFeedPresenter eventFeedPresenter) {
        this.eventFeedPresenter = eventFeedPresenter;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.setData(eventFeedPresenter.getEventList().get(position));
    }

    @Override
    public int getItemCount() {
        return eventFeedPresenter.size();
    }


    static class EventViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.event_title)
        TextView eventTitle;

        @BindView(R.id.event_image)
        ImageView eventImage;

        EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(Event event) {
            eventTitle.setText(event.getTitle());
            Picasso.with(App.get())
                    .load(event.getImages().get(0).getThumbnails().getLarge())
//                    .placeholder()
                    .into(eventImage);
        }
    }
}
