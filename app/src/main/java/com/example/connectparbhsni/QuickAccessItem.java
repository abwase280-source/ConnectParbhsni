package com.example.connectparbhsni;

public class QuickAccessItem {
    private String title;
    private String description;
    private int iconRes;
    private int iconColorRes;
    private int bgColorRes;

    public QuickAccessItem(String title, String description, int iconRes, int iconColorRes, int bgColorRes) {
        this.title = title;
        this.description = description;
        this.iconRes = iconRes;
        this.iconColorRes = iconColorRes;
        this.bgColorRes = bgColorRes;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getIconRes() { return iconRes; }
    public int getIconColorRes() { return iconColorRes; }
    public int getBgColorRes() { return bgColorRes; }
}