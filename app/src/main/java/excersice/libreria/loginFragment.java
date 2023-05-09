package excersice.libreria;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import excersice.libreria.data.DAOLibreria;
import excersice.libreria.data.Persona;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link loginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loginFragment extends Fragment implements View.OnClickListener,PersonaRecyclerViewAdapter.OnItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button registrar;
    private Button login;
    private RecyclerView listaPersonas;
    private PersonaRecyclerViewAdapter adaptadorPersona;
    private LinearLayoutManager linearLayoutManager;
    private DAOLibreria dbLibreria;

    public loginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static loginFragment newInstance(String param1, String param2) {
        loginFragment fragment = new loginFragment();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        registrar = (Button) view.findViewById(R.id.button4);
        login = (Button) view.findViewById(R.id.button2);
        registrar.setOnClickListener(this);
        login.setOnClickListener(this);
        // RecyclerView
        listaPersonas = (RecyclerView) view.findViewById( R.id.listaPersonasRV );
        dbLibreria = new DAOLibreria( this.getContext() );
        listaPersonas.setHasFixedSize( true );
        linearLayoutManager = new LinearLayoutManager( this.getContext() );
        listaPersonas.setLayoutManager( linearLayoutManager );
        adaptadorPersona = new PersonaRecyclerViewAdapter( this );
        listaPersonas.setAdapter( adaptadorPersona );
        loadUsuarios();
        super.onViewCreated(view, savedInstanceState);
    }

    private void loadUsuarios() {
        new UsuarioLoaderTask().execute( );
    }

    private class UsuarioLoaderTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return dbLibreria.getAllPersonas();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                adaptadorPersona.swapCursor( cursor );
            }
        }
    }

    @Override
    public void onClick(PersonaRecyclerViewAdapter.ViewHolder view, Persona personaActualizada) {
        dbLibreria.updatePersona( personaActualizada,Integer.toString(personaActualizada.getIdPersona()));
        loadUsuarios();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                Navigation.findNavController(view).navigate(R.id.storeFragment);
                break;
            case R.id.button4:
                Navigation.findNavController(view).navigate(R.id.registerFragment);
                break;
        }
    }
}