package vn.edu.csc.furniture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;


public class DashboardFragment extends Fragment {

    GridView gridView;
    ArrayList<Categories> arrayList;
    FurnitureAdapterGrid furnitureAdapterGrid;
    Utils utils;
    DBHelper dbHelper;
    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        utils = new Utils(getContext());
        dbHelper = new DBHelper(getContext());
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        gridView = view.findViewById(R.id.gridView);

        //arrayList = utils.getMockDataCategories();
        arrayList = dbHelper.getALLCategories();

        furnitureAdapterGrid = new FurnitureAdapterGrid(getContext(),arrayList);

        gridView.setAdapter(furnitureAdapterGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,CategoriesFragment.newInstance(i));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }


}