package com.jagex.runescape.util;

import com.jagex.runescape.Class15;
import com.jagex.runescape.Class47;
import com.jagex.runescape.Interface2;
import com.jagex.runescape.Runnable_Impl1;

import java.applet.Applet;
import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class Signlink implements Runnable {
    public static Method aMethod724;
    public static String homeDirectory;
    public static Method aMethod729;
    public static String aString735;
    public static int anInt737 = 3;
    public static String aString739;
    public boolean aBoolean721;
    public int anInt722 = 0;
    public Class47[] cacheIndex;
    public Class15 aClass15_725 = null;
    public Runnable_Impl1 aRunnable_Impl1_727;
    public Class47 aClass47_728;
    public InetAddress anInetAddress730;
    public Class15 aClass15_731 = null;
    public Interface2 anInterface2_732;
    public Thread aThread733;
    public String aString734 = null;
    public Class47 cacheData;
    public Applet anApplet740;

    public Signlink(boolean arg0, Applet arg1, InetAddress inetAddress, int fileStoreId, String cacheFolder, int cacheIndexes) throws IOException {
        aClass47_728 = null;
        cacheData = null;
        anApplet740 = null;
        anApplet740 = arg1;
        anInetAddress730 = inetAddress;
        aString739 = "1.1";
        aString735 = "Unknown";
        try {
            aString735 = System.getProperty("java.vendor");
            aString739 = System.getProperty("java.version");
            homeDirectory = System.getProperty("user.home");
            if(homeDirectory != null)
                homeDirectory += "/";
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(arg1 == null)
                aMethod729 = (Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE));
            else
                aMethod729 = (arg1.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE));
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(arg1 != null)
                aMethod724 = arg1.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
            else
                aMethod724 = (Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE));
        } catch(Exception exception) {
            /* empty */
        }
        if(arg0) {
            method397(-3849);
            cacheData = new Class47(new File(aString734 + "main_file_cache.dat2"), "rw", 52428800L);
            cacheIndex = new Class47[cacheIndexes];
            for(int i = 0; i < cacheIndexes; i++)
                cacheIndex[i] = new Class47(new File(aString734 + "main_file_cache.idx" + i), "rw", 1048576L);
            aClass47_728 = new Class47(new File(aString734 + "main_file_cache.idx255"), "rw", 1048576L);
            method390(6);
        }
        aBoolean721 = false;
        aThread733 = new Thread(this);
        aThread733.setPriority(10);
        aThread733.setDaemon(true);
        aThread733.start();

    }

    public void method385(int arg0) {
        synchronized(this) {
            aBoolean721 = true;
            this.notifyAll();
        }
        try {
            aThread733.join();
            if(arg0 != 0)
                method396(-55);
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
        if(aRunnable_Impl1_727 != null)
            aRunnable_Impl1_727.method1((byte) -102);
        if(cacheData != null) {
            try {
                cacheData.method917(1);
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(aClass47_728 != null) {
            try {
                aClass47_728.method917(arg0 ^ 0x1);
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(cacheIndex != null) {
            for(int i = 0; i < cacheIndex.length; i++) {
                if(cacheIndex[i] != null) {
                    try {
                        cacheIndex[i].method917(arg0 ^ 0x1);
                    } catch(IOException ioexception) {
                        /* empty */
                    }
                }
            }
        }
    }

    public Class15 method386(Class[] arg0, String arg1, Class arg2, byte arg3) {
        if(arg3 > -5)
            method389(-96, -109, 81, -55, null);
        return method389(106, 0, 9, 0, new Object[]{arg2, arg1, arg0});

    }

    public Interface2 method387(int arg0) {

        if(arg0 != -25100)
            return null;
        return anInterface2_732;

    }

    public Class15 method388(boolean arg0, URL arg1) {

        if(arg0 != false)
            method397(-42);
        return method389(124, 0, 4, 0, arg1);

    }

    public Class15 method389(int arg0, int arg1, int arg2, int arg3, Object arg4) {

        Class15 class15 = new Class15();
        class15.anObject435 = arg4;
        if(arg0 < 100)
            homeDirectory = null;
        class15.anInt432 = arg1;
        class15.anInt433 = arg2;
        synchronized(this) {
            if(aClass15_731 == null)
                aClass15_731 = aClass15_725 = class15;
            else {
                aClass15_731.aClass15_436 = class15;
                aClass15_731 = class15;
            }
            this.notify();
        }
        return class15;

    }

    public void method390(int arg0) {

        try {
            File file = new File(aString734 + "uid.dat");
            if(!file.exists() || file.length() < 4) {
                DataOutputStream dataoutputstream = (new DataOutputStream(new FileOutputStream(aString734 + "uid.dat")));
                dataoutputstream.writeInt((int) (9.9999999E7 * Math.random()));
                dataoutputstream.close();
            }
        } catch(Exception exception) {
            /* empty */
        }
        if(arg0 != 6)
            anInt722 = 116;
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(aString734 + "uid.dat"));
            anInt722 = 1 + datainputstream.readInt();
            datainputstream.close();
        } catch(Exception exception) {
            /* empty */
        }

    }

    public Runnable_Impl1 method391(int arg0) {

        if(arg0 != 1048576)
            method396(-47);
        return aRunnable_Impl1_727;

    }

    public void run() {

        for(; ; ) {
            Class15 class15;
            synchronized(this) {
                for(; ; ) {
                    if(aBoolean721)
                        return;
                    if(aClass15_725 != null) {
                        class15 = aClass15_725;
                        aClass15_725 = aClass15_725.aClass15_436;
                        if(aClass15_725 == null)
                            aClass15_731 = null;
                        break;
                    }
                    try {
                        this.wait();
                    } catch(InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
            }
            try {
                int i = class15.anInt433;
                if(i == 1)
                    class15.anObject437 = new Socket(anInetAddress730, class15.anInt432);
                else if(i != 2) {
                    if(i == 4)
                        class15.anObject437 = new DataInputStream(((URL) class15.anObject435).openStream());
                    else if(i == 9) {
                        Object[] objects = (Object[]) class15.anObject435;
                        class15.anObject437 = (((Class) objects[0]).getDeclaredMethod((String) objects[1], (Class[]) objects[2]));
                    } else if(i == 10) {
                        Object[] objects = (Object[]) class15.anObject435;
                        class15.anObject437 = ((Class) objects[0]).getDeclaredField((String) objects[1]);
                    } else
                        throw new Exception();
                } else {
                    Thread thread = new Thread((Runnable) class15.anObject435);
                    thread.setDaemon(true);
                    thread.start();
                    thread.setPriority(class15.anInt432);
                    class15.anObject437 = thread;
                }
                class15.anInt434 = 1;
            } catch(Exception exception) {
                class15.anInt434 = 2;
            }
        }

    }

    public Class15 method392(Class arg0, String arg1, boolean arg2) {

        if(arg2 != true)
            aString735 = null;
        return method389(126, 0, 10, 0, new Object[]{arg0, arg1});

    }

    public Class15 method393(int arg0, int arg1) {

        if(arg0 != 11545)
            return null;
        return method389(122, arg1, 3, 0, null);

    }

    public Class15 method394(int arg0, int arg1, Runnable arg2) {

        if(arg1 != 0)
            method392(null, null, false);
        return method389(114, arg0, 2, 0, arg2);

    }

    public Class15 method395(int arg0, int arg1) {

        if(arg0 != 3)
            method397(-29);
        return method389(125, arg1, 1, 0, null);

    }

    public Class15 method396(int arg0) {

        if(arg0 < 81)
            return null;
        return null;

    }

    public void method397(int arg0) {

        if(homeDirectory == null)
            homeDirectory = "~/";
        String fileStore = ".435cache";
        String[] cacheLocations = {"c:/rsrcache/", "/rsrcache/", "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", homeDirectory, "/tmp/", ""};
        if(arg0 != -3849)
            method392(null, null, false); // TODO: Does this even ever run?
        for(String cacheLocation : cacheLocations) {
            try {
                if(cacheLocation.length() > 0) {
                    File file = new File(cacheLocation);
                    if(!file.exists())
                        continue;
                }
                File file = new File(cacheLocation + fileStore);
                if(file.exists() || file.mkdir()) {
                    aString734 = file.getPath() + "/";
                    return;
                }
            } catch(Exception exception) {
            }
        }
        throw new RuntimeException();

    }
}
