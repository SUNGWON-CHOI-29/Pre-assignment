package viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.view.View;

public class MainViewmodel extends ViewModel {
    public final ObservableField<String> input = new ObservableField<>();
    public final ObservableField<String> output = new ObservableField<>();

    public void OnCreate() {
        output.set("Hi there!");
    }

    public void setSearchMovie(){
        output.set("Clicked");
    }
}
