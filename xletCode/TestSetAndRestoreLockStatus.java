package irdeto;

import java.util.ArrayList;
import java.util.List;

public class TestSetAndRestoreLockStatus {
    final static boolean[] lockStatusForTesting = { true, false, true, false };
    boolean[] originalLockStatus;
    List<Service> serviceList = new ArrayList<>();

    public static void main(String[] args) {
        TestSetAndRestoreLockStatus testLockStatus = new TestSetAndRestoreLockStatus();

        // BEFORE CHANGES
        System.out.println("Before Changes");
        System.out.println("-----------------");
        testLockStatus.initServices();
        testLockStatus.displayServicesInList();

        System.out.println("\nAfter Changes");
        System.out.println("-----------------");
        testLockStatus.doSetLockStatusForServicesUnderTest(lockStatusForTesting);
        testLockStatus.displayServicesInList();

        System.out.println("\nAfter Restoring");
        System.out.println("-----------------");
        testLockStatus.restoreLockStatusForServicesUnderTest();
        testLockStatus.displayServicesInList();
    }

    void initServices() {
        serviceList.add(new Service("dvb://1.1.1", false));
        serviceList.add(new Service("dvb://1.1.2", false));
        serviceList.add(new Service("dvb://1.1.3", true));
        serviceList.add(new Service("dvb://1.1.4", true));
    }

    public void doSetLockStatusForServicesUnderTest(boolean[] status) {
        int j = 0;
        originalLockStatus = new boolean[serviceList.size()];
        for (Service service : serviceList) {
            originalLockStatus[j] = service.isPersistentLocked;
            doSetLockStatusForServices(status[j++], service);
        }
    }

    /**
     * 
     * @param status
     * @param service
     * @throws InterruptedException
     */
    public void doSetLockStatusForServices(boolean status, final Service service) {
        if (status) {
            service.isPersistentLocked = true;
        } else {
            service.isPersistentLocked = false;
        }
    }

    /**
     * 
     * @throws InterruptedException
     */
    public void restoreLockStatusForServicesUnderTest() {
        int i = 0;
        for (Service service : serviceList) {
            doSetLockStatusForServices(originalLockStatus[i++], service);
        }
    }

    void displayServicesInList() {
        for (Service s : serviceList) {
            System.out.println(s);
        }
    }

}

class Service {
    String locator;
    boolean isPersistentLocked;

    public Service(String locator, boolean isPersistentLocked) {
        super();
        this.locator = locator;
        this.isPersistentLocked = isPersistentLocked;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Service [locator=" + locator + ", isPersistentLocked=" + isPersistentLocked + "]";
    }

}
