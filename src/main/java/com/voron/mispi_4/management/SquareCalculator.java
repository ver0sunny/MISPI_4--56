package com.voron.mispi_4.management;

import com.voron.mispi_4.Dot;
import org.springframework.lang.NonNull;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class SquareCalculator extends NotificationBroadcasterSupport implements SquareCalculatorMBean {
    private AtomicInteger totalDotAmount = new AtomicInteger(0);
    private double square = 0;
    private AtomicInteger notificationSequence = new AtomicInteger(1);
    private double delta = 0;

    private static SquareCalculator squareCalculator = new SquareCalculator();


    public static SquareCalculator getInstance() {
        return squareCalculator;
    }

    public double squareCalc(ArrayList<Dot> dotsArray) {
//        for (int i = 1; i < totalDotAmount.get(); i++) {
//            if (i == totalDotAmount.get() - 1) {
//                delta.set((int) (1 / 2 * (dotsArray.get(dotsArray.size() - 1 - i).getX() *
//                        (dotsArray.get(dotsArray.size() - 1 - i + 1).getY() - dotsArray.get(dotsArray.size() - 1).getY()))));
//                square.addAndGet(delta.get());
//            } else {
//                delta.set((int) (1 / 2 * (dotsArray.get(dotsArray.size() - 1 - i).getX() *
//                        (dotsArray.get(dotsArray.size() - 1 - i + 1).getY() - dotsArray.get(dotsArray.size() - 1 - i - 1).getY()))));
//                square.addAndGet(delta.get());
//            }
//        }

//        for (int i = 0; i < totalDotAmount.get(); i++) {
//            if (i == 0) {
//                delta.set((int) (0.5 * Math.abs((dotsArray.get(i).getX() *
//                        (dotsArray.get(i + 1).getY() - dotsArray.get(dotsArray.size() - 1).getY())))));
//                square.addAndGet(delta.get());
//
//            } else if (i == totalDotAmount.get() - 1) {
//                delta.set((int) (0.5 * Math.abs((dotsArray.get(i).getX() *
//                        (dotsArray.get(0).getY() - dotsArray.get(i - 1).getY())))));
//                square.addAndGet(delta.get());
//            } else {
//                delta.set((int) (0.5 * Math.abs((dotsArray.get(i).getX() *
//                        (dotsArray.get(i+1).getY() - dotsArray.get(i - 1).getY())))));
//                square.addAndGet(delta.get());
//                System.out.println("x " + dotsArray.get(i).getX());
//                System.out.println("y+1 " + dotsArray.get(i+1).getY());
//                System.out.println("y-1 " + dotsArray.get(i - 1).getY());
//                System.out.println("delta " + Math.abs((0.5 * (dotsArray.get(i).getX() *
//                        (dotsArray.get(i+1).getY() - dotsArray.get(i - 1).getY())))));
//            }
//
//        }

        for (int i = 0; i < totalDotAmount.get(); i++) {
            System.out.println("i = " + i);

//            if (i == 0) {
//                delta = (dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5 *
//                        (dotsArray.get(i + 1).getY()*dotsArray.get(i+1).getR()*0.5 - dotsArray.get(dotsArray.size() - 1).getY()*dotsArray.get(dotsArray.size() - 1).getR()*0.5));
//                square += delta;
//
//                System.out.println("x " + dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5);
//                System.out.println("y+1 " + dotsArray.get(i+1).getY()*dotsArray.get(i+1).getR()*0.5);
//                System.out.println("y-1 " + dotsArray.get(dotsArray.size() - 1).getY()*dotsArray.get(dotsArray.size() - 1).getR()*0.5);
//                System.out.println("delta " + (dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5 *
//                        (dotsArray.get(i + 1).getY()*dotsArray.get(i+1).getR()*0.5 - dotsArray.get(dotsArray.size() - 1).getY()*dotsArray.get(dotsArray.size() - 1).getR()*0.5)));
//
//            } else if (i == totalDotAmount.get() - 1) {
//                delta = (dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5 *
//                        (dotsArray.get(0).getY()*dotsArray.get(0).getR()*0.5 - dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5));
//                square += delta;
//
//                System.out.println("x " + dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5);
//                System.out.println("y+1 " + dotsArray.get(0).getY()*dotsArray.get(0).getR()*0.5);
//                System.out.println("y-1 " + dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5);
//                System.out.println("delta " + (dotsArray.get(i).getX()*0.5 *
//                        (dotsArray.get(0).getY()*dotsArray.get(0).getR()*0.5 - dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5)));
//
//            } else {
//                delta = (dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5 *
//                        (dotsArray.get(i + 1).getY()*dotsArray.get(i+1).getR()*0.5 - dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5));
//                square += delta;
//
//                System.out.println("x " + dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5);
//                System.out.println("y+1 " + dotsArray.get(i+1).getY()*dotsArray.get(i+1).getR()*0.5);
//                System.out.println("y-1 " + dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5);
//                System.out.println("delta " + (dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5 *
//                        (dotsArray.get(i+1).getY()*dotsArray.get(i+1).getR()*0.5 - dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5)));
//            }
//
            double X = dotsArray.get(i).getX()!=0 ? dotsArray.get(i).getX() : 1;

            if (i == 0) {
                delta = (X*dotsArray.get(i).getR()*0.5 *
                        (dotsArray.get(i + 1).getY()*dotsArray.get(i+1).getR()*0.5 - dotsArray.get(dotsArray.size() - 1).getY()*dotsArray.get(dotsArray.size() - 1).getR()*0.5));
                square += delta;

                System.out.println("x " + X*dotsArray.get(i).getR()*0.5);
                System.out.println("y+1 " + dotsArray.get(i+1).getY()*dotsArray.get(i+1).getR()*0.5);
                System.out.println("y-1 " + dotsArray.get(dotsArray.size() - 1).getY()*dotsArray.get(dotsArray.size() - 1).getR()*0.5);
                System.out.println("delta " + (dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5 *
                        (dotsArray.get(i + 1).getY()*dotsArray.get(i+1).getR()*0.5 - dotsArray.get(dotsArray.size() - 1).getY()*dotsArray.get(dotsArray.size() - 1).getR()*0.5)));

            } else if (i == totalDotAmount.get() - 1) {
                delta = (X*dotsArray.get(i).getR()*0.5 *
                        (dotsArray.get(0).getY()*dotsArray.get(0).getR()*0.5 - dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5));
                square += delta;

                System.out.println("x " + X*dotsArray.get(i).getR()*0.5);
                System.out.println("y+1 " + dotsArray.get(0).getY()*dotsArray.get(0).getR()*0.5);
                System.out.println("y-1 " + dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5);
                System.out.println("delta " + (dotsArray.get(i).getX()*0.5 *
                        (dotsArray.get(0).getY()*dotsArray.get(0).getR()*0.5 - dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5)));

            } else {
                delta = (X*dotsArray.get(i).getR()*0.5 *
                        (dotsArray.get(i + 1).getY()*dotsArray.get(i+1).getR()*0.5 - dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5));
                square += delta;

                System.out.println("x " + X*dotsArray.get(i).getR()*0.5);
                System.out.println("y+1 " + dotsArray.get(i+1).getY()*dotsArray.get(i+1).getR()*0.5);
                System.out.println("y-1 " + dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5);
                System.out.println("delta " + (dotsArray.get(i).getX()*dotsArray.get(i).getR()*0.5 *
                        (dotsArray.get(i+1).getY()*dotsArray.get(i+1).getR()*0.5 - dotsArray.get(i - 1).getY()*dotsArray.get(i - 1).getR()*0.5)));
            }

        }
        System.out.println("square = " + Math.abs(square) * 0.5);
        return Math.abs(square) * 0.5;
    }

    @Override
    public void process(ArrayList<Dot> dots) {
        totalDotAmount.getAndIncrement();
        if (totalDotAmount.get() > 2) {
            square = squareCalc(dots);
            Notification notification = new Notification("SQUARE", this,
                    notificationSequence.get(), "Shape square = " + square);
            sendNotification(notification);
            notificationSequence.getAndIncrement();
        }
    }
}

