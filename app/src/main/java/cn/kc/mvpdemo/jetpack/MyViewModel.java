package cn.kc.mvpdemo.jetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 作者： Abel .
 * 日期：2020/4/27
 * 说明：
 */
public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void addNumber(int num) {
        number.setValue(number.getValue() + num);
    }
}
