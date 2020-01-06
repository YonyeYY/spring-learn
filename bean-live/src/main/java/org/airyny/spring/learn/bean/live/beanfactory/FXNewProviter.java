package org.airyny.spring.learn.bean.live.beanfactory;

public class FXNewProviter {
    private DowJonesNewsListener newsListener;
    private DowJonesNewsPersister newsPersister;

    public FXNewProviter(DowJonesNewsListener newsListener,DowJonesNewsPersister newsPersister){
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public DowJonesNewsListener getNewsListener() {
        return newsListener;
    }

    public void setNewsListener(DowJonesNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public DowJonesNewsPersister getNewsPersister() {
        return newsPersister;
    }

    public void setNewsPersister(DowJonesNewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }
}
