package vn.edu.csc.furniture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);

        arrayList = getMockData();

        furnitureAdapter = new FurnitureAdapter(getContext(),arrayList);

        listView.setAdapter(furnitureAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Utils.furnitureHistory.add(arrayList.get(i));
                Toast.makeText(getContext(), i+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ArrayList<Furniture> getMockData(){
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture(getString(R.string.name_product_one), getString(R.string.product_one),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_1.png")));
        tmp.add(new Furniture(getString(R.string.name_product_tow), getString(R.string.product_tow),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_2.png")));
        tmp.add(new Furniture(getString(R.string.name_product_three), getString(R.string.product_three),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_3.png")));
        tmp.add(new Furniture(getString(R.string.name_product_four), getString(R.string.product_four),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_4.png")));
        tmp.add(new Furniture(getString(R.string.name_product_five), getString(R.string.product_five),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_5.png")));
        tmp.add(new Furniture(getString(R.string.name_product_one), getString(R.string.product_one),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_1.png")));
        tmp.add(new Furniture(getString(R.string.name_product_tow), getString(R.string.product_tow),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_2.png")));
        tmp.add(new Furniture(getString(R.string.name_product_three), getString(R.string.product_three),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_3.png")));
        tmp.add(new Furniture(getString(R.string.name_product_four), getString(R.string.product_four),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_4.png")));
        tmp.add(new Furniture(getString(R.string.name_product_five), getString(R.string.product_five),Furniture.convertStringToBitmapFromAccess(getContext(),"hinh_5.png")));
        return tmp;
    }
}