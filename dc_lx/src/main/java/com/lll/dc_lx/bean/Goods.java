package com.lll.dc_lx.bean;

import java.io.Serializable;

public class Goods implements Serializable {

//        "bargainPrice": 111.99,
//            "createtime": "2017-10-14T21:39:05",
//            "detailUrl": "https:\/\/item.m.jd.com\/product\/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends",
//            "images": "https:\/\/m.360buyimg.com\/n0\/jfs\/t9004\/210\/1160833155\/647627\/ad6be059\/59b4f4e1N9a2b1532.jpg!q70.jpg|https:\/\/m.360buyimg.com\/n0\/jfs\/t7504\/338\/63721388\/491286\/f5957f53\/598e95f1N7f2adb87.jpg!q70.jpg|https:\/\/m.360buyimg.com\/n0\/jfs\/t7441\/10\/64242474\/419246\/adb30a7d\/598e95fbNd989ba0a.jpg!q70.jpg",
//            "itemtype": 1,
//            "pid": 1,
//            "price": 118.0,
//            "pscid": 1,
//            "salenum": 0,
//            "sellerid": 17,
//            "subhead": "每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下",
//            "title": "北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g"

    private double bargainPrice;
    private String createtime;
    private String detailUrl;
    private String images;
    private int num;
    private int pid;
    private double price;
    private int pscid;
    private int selected;
    private int sellerid;
    private String subhead;
    private String title;
    private int count=1;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public double getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPscid() {
        return pscid;
    }

    public void setPscid(int pscid) {
        this.pscid = pscid;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
