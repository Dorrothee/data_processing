package data;

import Entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class dataList {

    private List<Entity> data = new ArrayList<>();

    public dataList() {
        this.data.add(new Entity(1, "assets/watch1.png", "Garmin MARQ Commander", 2590));
        this.data.add(new Entity(2, "assets/watch2.png", "Garmin Instinct 2 Solar Tactical", 610));
        this.data.add(new Entity(3, "assets/watch3.png", "Garmin Instinct 2 Solar", 490));
    }

    public List<Entity> getData() {
        return data;
    }

    public void setData(List<Entity> data) {
        this.data = data;
    }
}
