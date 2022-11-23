package com.example.baikiemtraso2;

import androidx.fragment.app.Fragment;

public class Tree extends Fragment {
    String Science_name, name, Characteristic, leaf_color, image;

    Tree() {

    }

    public Tree(String name, String describe, String image) {
        this.Science_name = Science_name;
        this.name = name;
        this.Characteristic = Characteristic;
        this.leaf_color = leaf_color;
        this.image = image;
    }

    public String getScience_name() {
        return Science_name;
    }

    public void setScience_name(String science_name) {
        Science_name = science_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristic() {
        return Characteristic;
    }

    public void setCharacteristic(String characteristic) {
        Characteristic = characteristic;
    }

    public String getLeaf_color() {
        return leaf_color;
    }

    public void setLeaf_color(String leaf_color) {
        this.leaf_color = leaf_color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
