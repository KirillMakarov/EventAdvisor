package com.elpatika.eventadvisor.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elpatika.eventadvisor.R;
import com.elpatika.eventadvisor.core.App;
import com.elpatika.eventadvisor.core.ScreenManager;
import com.elpatika.eventadvisor.model.Event;
import com.elpatika.eventadvisor.model.Thumbnails;
import com.elpatika.eventadvisor.ui.presenters.EventFeedPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.request.ImageRequest;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private EventFeedPresenter eventFeedPresenter;
    private Activity activity;

    @Inject
    ScreenManager screenManager;

    public EventsAdapter(EventFeedPresenter eventFeedPresenter, Activity activity) {
        this.eventFeedPresenter = eventFeedPresenter;
        this.activity = activity;
        App.component()
                .inject(this); // only app module
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


    class EventViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.event_title)
        TextView eventTitle;

        @BindView(R.id.event_image)
        DraweeView eventImage;

        EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int positionInList = getAdapterPosition();
                    List<Event> eventList = EventsAdapter.this.eventFeedPresenter.getEventList();
                    if (positionInList >= 0 && positionInList < eventList.size()) {
                        Event event = eventList.get(positionInList);
                        screenManager.showDetailActivityIntent(activity);
                    }
                }
            });
        }

        void setData(Event event) {
            eventTitle.setText(event.getTitle());
            Thumbnails thumbnails = event.getImages().get(0).getThumbnails();
            String large = thumbnails.getLarge();
            String small = thumbnails.getSmall();

            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setLowResImageRequest(ImageRequest.fromUri(small))
                    .setImageRequest(ImageRequest.fromUri(large))
                    .build();
            eventImage.setController(controller);
        }
    }
}
