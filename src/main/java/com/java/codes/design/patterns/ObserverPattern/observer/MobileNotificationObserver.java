package com.java.codes.design.patterns.ObserverPattern.observer;

import com.java.codes.design.patterns.ObserverPattern.observable.StockObservable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MobileNotificationObserver implements NotificationObserver {

    StockObservable stockObservable;
    String phoneNo;

    public MobileNotificationObserver(StockObservable stockObservable, String phoneNo) {
        this.stockObservable = stockObservable;
        this.phoneNo = phoneNo;
    }

    @Override
    public void sendNotification() {


        log.info("send the mobile notification");
    }

    @Override
    public void checkCurrentItemCount() {

        int count = stockObservable.getItems();
        log.info("available items : " + count);
    }
}
