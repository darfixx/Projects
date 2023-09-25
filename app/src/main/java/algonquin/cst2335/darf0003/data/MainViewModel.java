package algonquin.cst2335.darf0003.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> userString = new MutableLiveData("");

    public MutableLiveData<Boolean> onOrOff = new MutableLiveData<Boolean>(false);


}
