package vn.edu.ntu.nguyendinhhoanglan.demo_592;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

public class FirstFragment extends Fragment {
    NavController navController;
    private ListView mListView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        setHasOptionsMenu(true);
        navController = NavHostFragment.findNavController(this);
        Bundle data = getArguments();
        if (data != null){
            List<String> list = data.getStringArrayList("key");
            ArrayAdapter<String> adt = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);

            mListView = v.findViewById(R.id.listView);
            mListView.setAdapter(adt);
        }
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.first_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnAdd:
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}