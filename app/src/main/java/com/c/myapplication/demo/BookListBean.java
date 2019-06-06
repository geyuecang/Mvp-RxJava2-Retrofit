package com.c.myapplication.demo;

import java.util.List;

/**
 * author : geyuecang
 * date   : 2018/12/6 11:37
 * desc   : desc
 */
public class BookListBean {

    /**
     * list : [{"imgUrl":"http://neibuimg0.kfzimg.com/operation/ff/51/ff51af39ce54401caa1fcaf2ab1b5401.jpg","linkUrl":"kongfz://app.kongfz.com?page=web&type=1&url=DSGVSDF","title":"XFDFDDDFGDFSGV","description":"SDFGVSDGVDFSGDGVSDFGVSDFGVBDFS","activityUrl":"DSGVSDF","likeInfo":null},{"imgUrl":"http://neibuimg0.kfzimg.com/operation/c4/ee/c4eebdb3d9dd67fdbeed9019caf1b643.jpg","linkUrl":"kongfz://app.kongfz.com?page=web&type=1&url=http%3A%2F%2Fneibuwww.kongfz.com%2Fpromotion%2F89%2F","title":"推荐的","description":"了解前寒时代的政治变迁、社会风貌与学术文化，从历史中读懂中国","activityUrl":"http://neibuwww.kongfz.com/promotion/89/","likeInfo":{"likeNum":2,"myLike":0,"recentUserPic":["http://neibuuser.kongfz.com/data/member_pic/6107/5256107.jpg","http://neibuuser.kongfz.com/data/member_pic/6121/5256121.jpg"]}},{"imgUrl":"http://neibuimg0.kfzimg.com/operation/a3/59/a35907c91598af68e26d9d32ad014a0c.jpg","linkUrl":"kongfz://app.kongfz.com?page=web&type=1&url=http%3A%2F%2Fwww.kongfz.com%2Fpromotion%2Fjjdym_pc","title":"电影聚焦","description":"推荐大师电影，阅读阅读阅读阅读原著原著","activityUrl":"http://www.kongfz.com/promotion/jjdym_pc","likeInfo":{"likeNum":0,"myLike":0,"recentUserPic":[]}}]
     * pager : {"total":7,"currentPage":1,"pageShow":10,"totalPage":1}
     */

    private PagerBean pager;
    private List<ListBean> list;

    public PagerBean getPager() {
        return pager;
    }

    public void setPager(PagerBean pager) {
        this.pager = pager;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class PagerBean {
        /**
         * total : 7
         * currentPage : 1
         * pageShow : 10
         * totalPage : 1
         */

        private int total;
        private int currentPage;
        private int pageShow;
        private int totalPage;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getPageShow() {
            return pageShow;
        }

        public void setPageShow(int pageShow) {
            this.pageShow = pageShow;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        @Override
        public String toString() {
            return "PagerBean{" +
                    "total=" + total +
                    ", currentPage=" + currentPage +
                    ", pageShow=" + pageShow +
                    ", totalPage=" + totalPage +
                    '}';
        }
    }

    public static class ListBean {
        /**
         * imgUrl : http://neibuimg0.kfzimg.com/operation/ff/51/ff51af39ce54401caa1fcaf2ab1b5401.jpg
         * linkUrl : kongfz://app.kongfz.com?page=web&type=1&url=DSGVSDF
         * title : XFDFDDDFGDFSGV
         * description : SDFGVSDGVDFSGDGVSDFGVSDFGVBDFS
         * activityUrl : DSGVSDF
         * likeInfo : null
         */

        private String imgUrl;
        private String linkUrl;
        private String title;
        private String description;
        private String activityUrl;
        private LikeInfo likeInfo;
        private boolean isSupported;
        private int apv;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getActivityUrl() {
            return activityUrl;
        }

        public void setActivityUrl(String activityUrl) {
            this.activityUrl = activityUrl;
        }

        public LikeInfo getLikeInfo() {
            return likeInfo;
        }

        public void setLikeInfo(LikeInfo likeInfo) {
            this.likeInfo = likeInfo;
        }

        public void setIsSupported(boolean isSupported) {
            this.isSupported = isSupported;
        }

        public boolean getIsSupported() {
            return isSupported;
        }

        public int getApv() {
            return apv;
        }

        public void setApv(int apv) {
            this.apv = apv;
        }

        public static class LikeInfo {

            /**
             * likeNum : 2
             * myLike : 0
             * recentUserPic : ["http://neibuuser.kongfz.com/data/member_pic/6107/5256107.jpg","http://neibuuser.kongfz.com/data/member_pic/6121/5256121.jpg"]
             */

            private int likeNum;
            private int myLike;
            private List<String> recentUserPic;

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }

            public int getMyLike() {
                return myLike;
            }

            public void setMyLike(int myLike) {
                this.myLike = myLike;
            }

            public List<String> getRecentUserPic() {
                return recentUserPic;
            }

            public void setRecentUserPic(List<String> recentUserPic) {
                this.recentUserPic = recentUserPic;
            }

            @Override
            public String toString() {
                return "LikeInfo{" +
                        "likeNum=" + likeNum +
                        ", myLike=" + myLike +
                        ", recentUserPic=" + recentUserPic +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "imgUrl='" + imgUrl + '\'' +
                    ", linkUrl='" + linkUrl + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", activityUrl='" + activityUrl + '\'' +
                    ", likeInfo=" + likeInfo +
                    ", isSupported=" + isSupported +
                    ", apv=" + apv +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BookListBean{" +
                "pager=" + pager +
                ", list=" + list +
                '}';
    }
}
