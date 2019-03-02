package ml.mozillabbsr.www.mozillabbsr;

/**
 * Created by KIIT on 02-03-2019.
 */

public class Data {
    int imgurl;
    String title;


    public Data(int imgurl, String title) {
        this.imgurl = imgurl;
        this.title = title;
    }

    public int getImgurl() {
        return imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setImgurl(int imgurl) {
        this.imgurl = imgurl;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
