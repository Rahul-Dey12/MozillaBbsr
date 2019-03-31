package ml.mozillabbsr.www.mozillabbsr;

/**
 * Created by KIIT on 02-03-2019.
 */

public class eventData {
    String logourl;
    String name;
    String date;
    String title;
    String poster;
    String key;
    public eventData() {
    }

    public eventData(String logourl, String name, String date, String title, String poster) {
        this.logourl = logourl;
        this.name = name;
        this.date = date;
        this.title = title;
        this.poster = poster;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
