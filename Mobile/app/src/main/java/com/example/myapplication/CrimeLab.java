package com.example.myapplication;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private  static CrimeLab sCrimeLab;

    public static CrimeLab get(Context context){
        if ( sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private List<Crime> mCrime;
    private CrimeLab(Context context){
        mCrime = new ArrayList<Crime>();
        for (int i =0 ; i<100; i++){
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSolved(i % 2 == 0);
            mCrime.add(crime);
        }
    }
    public List<Crime> getmCrime(){return mCrime;}

    public Crime getCrime(UUID id){
        for (Crime crime : mCrime)
            if (crime.getmID().equals(id))
                return crime;
            return null;
    }

}
