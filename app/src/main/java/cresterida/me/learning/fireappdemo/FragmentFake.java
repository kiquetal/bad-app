package cresterida.me.learning.fireappdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kiquetal on 8/9/17.
 */

public class FragmentFake extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


       return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_test,null);

    }


}
