package com.example.nbateamsproject.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nbateamsproject.R;
import com.example.nbateamsproject.teamsJSON.NbaItems;

import java.util.List;

public class NbaTeamsAdapter extends RecyclerView.Adapter<NbaTeamsAdapter.NbaTeamsViewHolder> {

    private NbaTeamClickListener nbaTeamClickListener;
    private List<NbaItems> nbaItemsList;

    public NbaTeamsAdapter(List<NbaItems> nbaItemsList) {
        this.nbaItemsList = nbaItemsList;
    }

    public void setNbaTeamClickListener(NbaTeamClickListener nbaTeamClickListener) {
        this.nbaTeamClickListener = nbaTeamClickListener;
    }

    @NonNull
    @Override
    public NbaTeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new NbaTeamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NbaTeamsViewHolder holder, int position) {
        holder.teamName.setText(nbaItemsList.get(position).getTeamName());
    }

    @Override
    public int getItemCount() {
        return nbaItemsList.size();
    }

    public class NbaTeamsViewHolder extends RecyclerView.ViewHolder {

        private TextView teamName;

        public NbaTeamsViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.teamName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nbaTeamClickListener.onClick(getAdapterPosition());
                }
            });
        }
    }
}
