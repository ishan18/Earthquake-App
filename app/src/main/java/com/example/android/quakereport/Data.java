package com.example.android.quakereport;

public class Data {
    String location,time,date,url;
    Double mag;
    public Data(Double mag,String location,String time,String date,String url)
    {
        this.mag=mag;
        this.location=location;
        this.time=time;
        this.date=date;
        this.url=url;
    }

    public Double getMag()
    {
        return mag;
    }
    public String getLocation()
    {
        return location;
    }
    public String getTime()
    {
        return time;
    }
    public String getDate() { return date;}
    public String getUrl() { return url;}
}

