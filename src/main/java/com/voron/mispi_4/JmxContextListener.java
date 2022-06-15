package com.voron.mispi_4;

import com.voron.mispi_4.management.DotChecker;
import com.voron.mispi_4.management.MBeanListener;
import com.voron.mispi_4.management.SquareCalculator;
import com.voron.mispi_4.management.TimeSpanQualifier;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;

public class JmxContextListener implements ServletContextListener {

    private static final String dotCheckerMBeanName = "com.voron.mispi_4:type=mbeans,name=dot_checker";
    private static final String timeSpanQualifierMBeanName = "com.voron.mispi_4:type=mbeans,name=time_span_qualifier";
    private static final String squareCalculatorMBeanName = "com.voron.mispi_4:type=mbeans,name=square_calculator";


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

            ObjectName dotCheckerObjectName = new ObjectName(dotCheckerMBeanName);
            DotChecker dotChecker = DotChecker.getInstance();
            mBeanServer.registerMBean(dotChecker, dotCheckerObjectName);

            ObjectName timeSpanQualifierObjectName = new ObjectName(timeSpanQualifierMBeanName);
            TimeSpanQualifier timeSpanQualifier = TimeSpanQualifier.getInstance();
            mBeanServer.registerMBean(timeSpanQualifier, timeSpanQualifierObjectName);

            ObjectName squareCalculatorObjectName = new ObjectName(squareCalculatorMBeanName);
            SquareCalculator squareCalculator = SquareCalculator.getInstance();
            mBeanServer.registerMBean(squareCalculator, squareCalculatorObjectName);

            MBeanListener dotCheckerListener = new MBeanListener("dotChecker");
            mBeanServer.addNotificationListener(dotCheckerObjectName, dotCheckerListener, dotCheckerListener.getNotificationFilter(), null);

            MBeanListener squareCalculatorListener = new MBeanListener("squareCalculator");
            mBeanServer.addNotificationListener(squareCalculatorObjectName, squareCalculatorListener, squareCalculatorListener.getNotificationFilter(), null);
        } catch (Exception e) {
            System.err.println("Error registering MBean: " + e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

            ObjectName dotCheckerObjectName = new ObjectName(dotCheckerMBeanName);
            mBeanServer.unregisterMBean(dotCheckerObjectName);

            ObjectName squareCalculatorObjectName = new ObjectName(squareCalculatorMBeanName);
            mBeanServer.unregisterMBean(squareCalculatorObjectName);

            ObjectName timeSpanQualifierObjectName = new ObjectName(timeSpanQualifierMBeanName);
            mBeanServer.unregisterMBean(timeSpanQualifierObjectName);

        } catch (Exception e) {
            System.err.println("Error unregistering MBean: " + e);
        }
    }
}
