package data;

import Entities.Watches;

import java.util.ArrayList;
import java.util.List;

public class dataList {

    private List<Watches> data = new ArrayList<>();

    public dataList() {
        this.data.add(new Watches(1, "assets/watch1.png", "Garmin MARQ Commander", 2590));
        this.data.add(new Watches(2, "assets/watch2.png", "Garmin Instinct 2 Solar Tactical", 610));
        this.data.add(new Watches(3, "assets/watch3.png", "Garmin Instinct 2 Solar", 490));
    }

    public List<Watches> getData() {
        return data;
    }

    public void setData(List<Watches> data) {
        this.data = data;
    }
}
