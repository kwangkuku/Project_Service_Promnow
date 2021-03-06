package com.promptnow.econprice.fragment.lottery;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.view.View_popup;

import java.util.ArrayList;

/**
 * Created by Whankung on 7/9/2559.
 */

public class LotteryFragment extends Fragment implements View_popup.onSubmitAlertDialogListener {
    private View rootView;
    EditText input;
    private TextView tv, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    private Spinner spin;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.checklottery, container, false);
        setView();
        // setDate();
        setNumber();
        LottoSpinner();
        //setContent();
        setDummy();

        return rootView;
    }

    private void LottoSpinner() {

        spin = (Spinner) rootView.findViewById(R.id.spin);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1 กันยายน 2559");
        arrayList.add("16 สิงหาคม 2559");
        arrayList.add("1 สิงหาคม 2559");
        arrayList.add("16 กรกฏาคม 2559");

        ArrayAdapter<String> lottoAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, arrayList);
        spin.setAdapter(lottoAdapter);


        spin = (Spinner) rootView.findViewById(R.id.spin);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                setDummy();
                if (i == 1) {
                    setContent();
                } else if (i == 2) {
                    setContent2();
                } else if (i == 3) {
                    setContent3();
                }
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

    }


    private void setView() {
//        รางวัลที่1
        tv = (TextView) rootView.findViewById(R.id.lot_num);
//        เลขท้าย 2 ตัว
        tv2 = (TextView) rootView.findViewById(R.id.lot_num2);
//        เลขหน้า 3 ตัว
        tv3 = (TextView) rootView.findViewById(R.id.lot_num3);
//         เลขท้าย 3 ตัว
        tv4 = (TextView) rootView.findViewById(R.id.lot_num4);
//        รางวัลใกล้เคียงรางวัลที่1
        tv5 = (TextView) rootView.findViewById(R.id.lot_num5);
//        รางวัลที่2
        tv6 = (TextView) rootView.findViewById(R.id.lot_num6);
//        รางวัลที่3
        tv7 = (TextView) rootView.findViewById(R.id.lot_num7);
//        รางวัลที่4
        tv8 = (TextView) rootView.findViewById(R.id.lot_num8);
//        รางวัลที่5
        tv9 = (TextView) rootView.findViewById(R.id.lot_num9);


    }

    private void setDummy() {
        tv.setText("254004");
        tv2.setText("33");
        tv3.setText("994 004");
        tv4.setText("654 764");
        tv5.setText("114505 000503");
        tv6.setText("674107 002226 199098");
        tv7.setText("000245 222214 110008");
        tv8.setText("003111 034533 132999");
        tv9.setText("276600 211111 001739");
    }

    private void setContent() {
        tv.setText("209067");
        tv2.setText("01");
        tv3.setText("558 150");
        tv4.setText("003 151");
        tv5.setText("114545 111503");
        tv6.setText("222107 333226 555098");
        tv7.setText("035655 111114 097568");
        tv8.setText("126593 999533 464999");
        tv9.setText("345699 154646 895739");
    }

    private void setContent2() {
        tv.setText("454567");
        tv2.setText("11");
        tv3.setText("118 190");
        tv4.setText("803 150");
        tv5.setText("114505 000503");
        tv6.setText("671107 342226 110098");
        tv7.setText("111245 212114 111668");
        tv8.setText("003393 008533 118999");
        tv9.setText("276699 211146 211739");
    }

    private void setContent3() {
        tv.setText("111147");
        tv2.setText("67");
        tv3.setText("188 590");
        tv4.setText("883 050");
        tv5.setText("854505 432503");
        tv6.setText("674007 346866 210098");
        tv7.setText("083245 214764 213668");
        tv8.setText("323393 008533 118999");
        tv9.setText("765699 111467 673739");
    }

//    private void setDate() {
//        spin = (Spinner) rootView.findViewById(R.id.spin);
//
//        spin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//    spin.performClick();
//
//            }
//        });
//    }


    private void setNumber() {

        input = (EditText) rootView.findViewById(R.id.seach_num);
        input.addTextChangedListener(watch);

    }

    private TextWatcher watch = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable arg0) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {

        }

        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c) {
            Log.d("log", "123");
            String prefix = "000000";
            String strMsg = "";
            if (s.toString().endsWith(prefix)) {
                strMsg = getResources().getString(R.string.str_msgTrue);
                View_popup alertDialog = new View_popup(strMsg,"ตกลง");
                alertDialog.mListener = LotteryFragment.this;
                alertDialog.show(getFragmentManager(), "");
            } else if (s.toString().length() == 6) {
                strMsg = getResources().getString(R.string.str_msgFail);

                View_popup alertDialog = new View_popup(strMsg,"ตกลง");

                alertDialog.mListener = LotteryFragment.this;
                alertDialog.show(getFragmentManager(), "");
            }

        }

    };

    @Override
    public void setOnSubmitAlertDialogListener() {

    }
}














