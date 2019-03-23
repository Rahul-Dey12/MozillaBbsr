package ml.mozillabbsr.www.mozillabbsr;

/**
 * Created by KIIT on 22-03-2019.
 */

public class speakerData {
    int imgurl;
    String name;
    String title;

    public speakerData(int imgurl, String name, String title) {
        this.imgurl = imgurl;
        this.name = name;
        this.title = title;
    }

    public int getImgurl() {
        return imgurl;
    }

    public void setImgurl(int imgurl) {
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
