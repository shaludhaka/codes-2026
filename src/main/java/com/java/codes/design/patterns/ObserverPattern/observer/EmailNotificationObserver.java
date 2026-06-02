package com.java.codes.design.patterns.ObserverPattern.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotificationObserver implements NotificationObserver {

    @Override
    public void sendNotification() {

        log.info("send the email notification");
    }

    @Override
    public void checkCurrentItemCount() {

    }
}
