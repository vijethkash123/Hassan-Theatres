package com.example.vijeth.hassantheatres;

/**
 * Created by Hp on 5/1/2017.
 */

public class ListItem {

    private String head;
    private String desc;
    private String imageUrl;
    private String trailer;


    public ListItem(String head, String desc, String imageUrl,String trailer) {
        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.trailer = trailer;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getTrailer(){
        return trailer;
    }
}
