package com.java.codes.design.patterns.ObserverPattern.observable;

import com.java.codes.design.patterns.ObserverPattern.observer.NotificationObserver;

public interface StockObservable {

    public void add(NotificationObserver notificationObserver);

    public void remove(NotificationObserver notificationObserver);

    public int getItems();

    public void notifyAllUsers(NotificationObserver notificationObserver);

    public void setStockCount(int newStockAdded);
}
