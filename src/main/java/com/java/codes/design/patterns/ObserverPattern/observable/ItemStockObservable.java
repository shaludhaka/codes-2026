package com.java.codes.design.patterns.ObserverPattern.observable;

import com.java.codes.design.patterns.ObserverPattern.observer.NotificationObserver;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ItemStockObservable implements StockObservable {

    @Getter
    List<NotificationObserver> notificationObservers = new ArrayList<>();

    int stockCount = 0;

    public void add(NotificationObserver notificationObserver) {
        notificationObservers.add(notificationObserver);
    }

    public void remove(NotificationObserver notificationObserver) {
        notificationObservers.remove(notificationObserver);
    }

    public int getItems() {
        return stockCount;
    }

    public void notifyAllUsers(NotificationObserver notificationObserver) {
        notificationObserver.sendNotification();
    }

    public void checkStock(NotificationObserver notificationObserver) {
        notificationObserver.checkCurrentItemCount();
    }

    @Override
    public void setStockCount(int newStockAdded) {

        for (NotificationObserver notificationObserver : notificationObservers) {
            notificationObserver.checkCurrentItemCount();
            if (stockCount == 0) {
                notifyAllUsers(notificationObserver);
            }
            stockCount = stockCount + newStockAdded;
            notificationObserver.checkCurrentItemCount();
        }
    }
}
