package com.anlaiye.swt.justtalkapp.model;

import java.util.List;

/**
 * 介绍：
 * 作者：jacky
 * 邮箱：hewei@incoming.cn
 * 时间: 16/4/24 上午12:25
 */

public class AdListBean {


    /**
     * total : 1
     * list : [{"adId":112,"title":"航海王","imageUrl":"http://pic.anlaiye.com.cn/1b310e134d35432d8d0c6ecd302acf12.jpg","type":3,"data":"{}","showTime":0,"canClose":true}]
     * pageNum : 1
     * pageSize : 100
     * pages : 1
     * size : 1
     */

    private int total;
    private int pageNum;
    private int pageSize;
    private int pages;
    private int size;
    /**
     * adId : 112
     * title : 航海王
     * imageUrl : http://pic.anlaiye.com.cn/1b310e134d35432d8d0c6ecd302acf12.jpg
     * type : 3
     * data : {}
     * showTime : 0
     * canClose : true
     */

    private List<AdBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<AdBean> getList() {
        return list;
    }

    public void setList(List<AdBean> list) {
        this.list = list;
    }

    public static class AdBean {
        private int adId;
        private String title;
        private String imageUrl;
        private int type;
        private String data;
        private int showTime;
        private boolean canClose;

        public int getAdId() {
            return adId;
        }

        public void setAdId(int adId) {
            this.adId = adId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getShowTime() {
            return showTime;
        }

        public void setShowTime(int showTime) {
            this.showTime = showTime;
        }

        public boolean isCanClose() {
            return canClose;
        }

        public void setCanClose(boolean canClose) {
            this.canClose = canClose;
        }
    }
}
