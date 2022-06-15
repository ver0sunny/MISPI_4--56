package com.voron.mispi_4.management;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.concurrent.atomic.AtomicInteger;

public class DotChecker extends NotificationBroadcasterSupport implements DotCheckerMBean {

    private AtomicInteger totalDotAmount = new AtomicInteger(0);
    private AtomicInteger missesInRow = new AtomicInteger(0);
    private AtomicInteger notificationSequence = new AtomicInteger(1);

    private static DotChecker dotChecker = new DotChecker();

    public static DotChecker getInstance() {
        return dotChecker;
    }

    @Override
    public void process(boolean result) {
        totalDotAmount.getAndIncrement();
        if (result) {
            missesInRow.set(0);
        } else {
            missesInRow.getAndIncrement();
            if (missesInRow.get() >= 2) {
                Notification notification = new Notification("Dot missed", this,
                        notificationSequence.get(), "User got " + missesInRow + " misses in a row");
                sendNotification(notification);
                notificationSequence.getAndIncrement();
            }
        }

    }
}
