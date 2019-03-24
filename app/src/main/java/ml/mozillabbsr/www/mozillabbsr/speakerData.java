package ml.mozillabbsr.www.mozillabbsr;

/**
 * Created by KIIT on 22-03-2019.
 */

public class speakerData {
    String imgurl;
    String name;
    String title;

    public speakerData() {
    }

    public speakerData(String imgurl, String name, String title) {
        this.imgurl = imgurl;
        this.name = name;
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
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
