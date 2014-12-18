package com.onefinestay.onefinestay.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.onefinestay.onefinestay.R;
import com.onefinestay.onefinestay.UnitsActivity;
import com.onefinestay.onefinestay.adapters.HouseLevelAdapter;
import com.onefinestay.onefinestay.dao.HouseDataStorage;
import com.onefinestay.onefinestay.model.IHouseLevelModel;

/**
 * Fragment represents first level of house
 */
public class HouseFirstLevelFragment extends Fragment {

    private final String TAG = getClass().getSimpleName();
    private ListView unitList;
    private HouseLevelAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_house_listview, container, false);
        unitList = (ListView) rootView.findViewById(R.id.listView);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new HouseLevelAdapter(getActivity(),
                HouseDataStorage.getInstance().getHouseList());
        unitList.setAdapter(adapter);
        unitList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                onClickItem(position);

            }
        });
    }

    private void onClickItem(int position) {
        HouseSecondLevelFragment newFragment = new HouseSecondLevelFragment();
        Bundle args = new Bundle();
        IHouseLevelModel levelModel = (IHouseLevelModel)adapter.getHouseLevelModelList().get(position);
        if(levelModel.getHouseLevelList() == null) {
            Toast.makeText(this.getActivity(), R.string.no_data, Toast.LENGTH_SHORT).show();
            return;
        }
        args.putParcelable(UnitsActivity.HOUSE_LEVEL_MODEL,levelModel);
        newFragment.setArguments(args);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        Log.d(TAG, "commit");
    }


}
