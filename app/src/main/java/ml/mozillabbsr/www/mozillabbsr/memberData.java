package ml.mozillabbsr.www.mozillabbsr;

/**
 * Created by KIIT on 24-03-2019.
 */

public class memberData {
    String name;
    String title;
    String desg;
    String imgurl;

    public memberData() {
    }

    public memberData(String name, String title, String desg, String imgurl) {
        this.name = name;
        this.title = title;
        this.desg = desg;
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

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
