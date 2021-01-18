package com.example.nbateamsproject.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.nbateamsproject.R;

public class DetailedTeamPage extends Fragment {
    private TextView teamName;
    private TextView shortTeamName;
    private TextView location;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        teamName = view.findViewById(R.id.teamNameOfDetailedPage);
        shortTeamName = view.findViewById(R.id.teamShortname);
        location = view.findViewById(R.id.teamLocation);

        getParentFragmentManager().setFragmentResultListener("nbaTeamsKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                teamName.setText(bundle.getString("nameKey"));
                location.setText(bundle.getString("locationKey"));
                shortTeamName.setText(bundle.getString("shortNameKey"));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detailed_team_page, container, false);
    }
}