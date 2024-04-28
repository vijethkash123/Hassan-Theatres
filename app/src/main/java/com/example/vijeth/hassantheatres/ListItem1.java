package com.example.vijeth.hassantheatres;

/**
 * Created by Hp on 5/1/2017.
 */

public class ListItem1 {

    private String head1;
    private String desc1;
    private String imageUrl1;


    public ListItem1(String head1, String desc1, String imageUrl1) {
        this.head1 = head1;
        this.desc1 = desc1;
        this.imageUrl1 = imageUrl1;
    }

    public String getHead() {
        return head1;
    }

    public String getDesc() {
        return desc1;
    }

    public String getImageUrl() {
        return imageUrl1;
    }
}
