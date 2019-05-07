package minkowitz.net;

public class Photo {

    private String url;

    private String title;

    private String id;

    public String getUrl()
    {
        return url;
    }

    public String getTitle()
    {
        return title;
    }

    private  String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Photo{" +
                "url='" + url + '\'' +
                '}';
    }
}


