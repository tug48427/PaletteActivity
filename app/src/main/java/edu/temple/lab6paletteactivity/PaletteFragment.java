package edu.temple.lab6paletteactivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaletteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {
    /*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
*/
    // OnFragmentInteractionListener mListener;
    OnPaletteSelectedListener call;
    FragmentActivity listener;
    final static String colors = "colors";
    final static String colorsEN= "colorsEn";


    public PaletteFragment() {
        // Required empty public constructor
    }


    public static PaletteFragment newInstance (String[] colorArr, String[] colorArrEn){
        PaletteFragment paletteFragment = new PaletteFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(colors,colorArr);//add string res
        bundle.putStringArray(colorsEN,colorArrEn);
        paletteFragment.setArguments(bundle);
        return  paletteFragment;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        String[] colorS = getArguments().getStringArray(colors);
        String[] colorEN=getArguments().getStringArray(colorsEN);

         */

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = (View) inflater.inflate(R.layout.fragment_palette, container, false);
        String[] colorVals = getArguments().getStringArray(colors);
        String[] enColorVals = getArguments().getStringArray(colorsEN);
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);

        ColorAdapter adapter = new ColorAdapter(this.getActivity(),colorVals,colorVals.length,enColorVals);
        spinner.setAdapter(adapter);
        spinner.setSelection(0,false);


        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                view.setBackgroundColor(Color.WHITE);




                if (i != 0) {
                    //view.setBackgroundColor(Color.WHITE);

                    call.onColorSelected(i);

                }else{
                    view.setBackgroundColor(Color.WHITE);
                }


            }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
        return v;


    }


    /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            this.listener=(FragmentActivity)context;
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    /*
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    */

    public void OnPaletteSelectedListener (OnPaletteSelectedListener getCall) {
        this.call=getCall;

    }

    public interface OnPaletteSelectedListener{
        public void onColorSelected(int postion);
    }
}
