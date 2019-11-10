package com.astra.discoversv.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alespero.expandablecardview.ExpandableCardView;
import com.astra.discoversv.Adapters.ContactAdapter;
import com.astra.discoversv.Classes.Space;
import com.astra.discoversv.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactFragment extends Fragment {

//    @BindView(R.id.recycler_contactInfo) RecyclerView contact_Rv;
    @BindView(R.id.contact_taxi)
    ExpandableCardView taxiCard;
    @BindView(R.id.contact_general) ExpandableCardView generalCard;
    @BindView(R.id.contact_tour) ExpandableCardView tourCard;

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

       RecyclerView generalRV = generalCard.getRootView().findViewById(R.id.recycler_contactInfo);
       RecyclerView taxiRV = taxiCard.getRootView().findViewById(R.id.recycler_contactInfo1);
       RecyclerView tourRV = tourCard.getRootView().findViewById(R.id.recycler_contactInfo2);

       initCards(generalRV, "general");
       initCards(taxiRV, "taxi");
       initCards(tourRV, "tour");

       generalCard.setIcon(R.drawable.contact_icon);
       taxiCard.setIcon(R.drawable.taxi_icon);
       tourCard.setIcon(R.drawable.tour_icon);

        return view;
    }

    private void initCards(RecyclerView recyclerView, String type){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new Space(20, 1));
        recyclerView.setAdapter(new ContactAdapter(getActivity(), type));
    }


}
