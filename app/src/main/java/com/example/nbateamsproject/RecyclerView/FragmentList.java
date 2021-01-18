package com.example.nbateamsproject.RecyclerView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nbateamsproject.MainActivity;
import com.example.nbateamsproject.R;
import com.example.nbateamsproject.network.GetDataService;
import com.example.nbateamsproject.network.retrofitClient;
import com.example.nbateamsproject.teamsJSON.NbaItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentList extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);

        GetDataService getDataService = retrofitClient.getRetrofit().create(GetDataService.class);

        Call<List<NbaItems>> calledList = getDataService.getTeams();

        calledList.enqueue(new Callback<List<NbaItems>>() {
            @Override
            public void onResponse(Call<List<NbaItems>> call, Response<List<NbaItems>> response) {
                List<NbaItems> nbaItemsList = response.body();
                if (nbaItemsList != null) {
                    NbaTeamsAdapter adapter = new NbaTeamsAdapter(nbaItemsList);
                    recyclerView.setAdapter(adapter);

                    adapter.setNbaTeamClickListener(new NbaTeamClickListener() {
                        @Override
                        public void onClick(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putString("nameKey",nbaItemsList.get(position).getTeamName());
                            bundle.putString("locationKey",nbaItemsList.get(position).getLocation());
                            bundle.putString("shortNameKey",nbaItemsList.get(position).getAbbreviation());
                            getParentFragmentManager().setFragmentResult("nbaTeamsKey", bundle);
                            ((MainActivity) getActivity()).onClick(view);

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<NbaItems>> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}