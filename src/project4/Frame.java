package project4;

import java.util.ArrayList;

/**
 * Created by paulberesuita on 4/5/15.
 */
public class Frame {

    ArrayList<RavensObject> objects = null;

    public Frame() {

        this.objects = null;
    }

    public Frame(ArrayList<RavensObject> objects) {

        this.objects = objects;
    }

    public ArrayList<RavensObject> getObjects() {

        return objects;
    }

    public void setObjects(ArrayList<RavensObject> objects) {

        this.objects = objects;
    }
}
