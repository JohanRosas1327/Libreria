package excersice.libreria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link storeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class storeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button store;
    private Button store1;
    private Button store2;

    public storeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment storeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static storeFragment newInstance(String param1, String param2) {
        storeFragment fragment = new storeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        store = (Button) view.findViewById(R.id.button3);
        store1 = (Button) view.findViewById(R.id.button5);
        store2 = (Button) view.findViewById(R.id.button6);
        store.setOnClickListener(this);
        store1.setOnClickListener(this);
        store2.setOnClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button3:
                Navigation.findNavController(view).navigate(R.id.paidFragment);
                break;
            case R.id.button5:
                Navigation.findNavController(view).navigate(R.id.paidFragment);
                break;
            case R.id.button6:
                Navigation.findNavController(view).navigate(R.id.paidFragment);
                break;
        }
    }
}
