package com.java.codes;

import com.java.codes.design.patterns.ObserverPattern.observable.ItemStockObservable;
import com.java.codes.design.patterns.ObserverPattern.observer.MobileNotificationObserver;
import com.java.codes.design.patterns.ObserverPattern.observer.NotificationObserver;

public class Stock {

    public static void main(String[] args) {

        ItemStockObservable itemStockObservable = new ItemStockObservable();

        NotificationObserver mobileNotificationObserver = new MobileNotificationObserver(itemStockObservable, "90900000");

        itemStockObservable.add(mobileNotificationObserver);
        itemStockObservable.setStockCount(10);
    }
}
