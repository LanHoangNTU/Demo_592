package vn.edu.ntu.nguyendinhhoanglan.demo_592;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SecondFragment extends Fragment {
    private NavController navController;
    private EditText mEdtMon;
    private EditText mEdtDate;
    private ImageView mImvDate;
    private EditText mEdtDate2;
    private ImageView mImvDate2;
    private EditText mEditTextTextPersonName2;
    private Spinner mSpinner;
    private Button mButton;
    private Button mButtonSecond;
    private List<String> list = new ArrayList<>();
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        mEdtMon = v.findViewById(R.id.edtMon);
        mEdtDate = v.findViewById(R.id.edtDate);
        mImvDate = v.findViewById(R.id.imvDate);
        mEdtDate2 = v.findViewById(R.id.edtDate2);
        mImvDate2 = v.findViewById(R.id.imvDate2);
        mEditTextTextPersonName2 = v.findViewById(R.id.editTextTextPersonName2);
        mSpinner = v.findViewById(R.id.spinner);
        mButton = v.findViewById(R.id.button);
        mButtonSecond = v.findViewById(R.id.button_second);
        navController = NavHostFragment.findNavController(this);
        String[] arr = getActivity().getResources().getStringArray(R.array.ht_thi);
        ArrayAdapter<String> adt = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arr);
        mSpinner.setAdapter(adt);
        mButtonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putStringArrayList("key", (ArrayList<String>) list);
                navController.navigate(R.id.action_SecondFragment_to_FirstFragment, data);
            }
        });

        mImvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        mEdtDate.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });

        mImvDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        mEdtDate2.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        listener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addString();
            }
        });
        return v;
    }

    private void addString() {
        StringBuilder s = new StringBuilder();
        String htt = mSpinner.getSelectedItem().toString();
        s.append("Môn học: ").append(mEdtMon.getText().toString())
                .append("\nNgày bắt đầu: ").append(mEdtDate.getText().toString())
                .append("\nNgày kết thúc: ").append(mEdtDate2.getText().toString())
                .append("\nĐịa điểm: ").append(mEditTextTextPersonName2.getText().toString())
                .append("\nHình thức: ").append(htt);
        list.add(s.toString());
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
    }
}