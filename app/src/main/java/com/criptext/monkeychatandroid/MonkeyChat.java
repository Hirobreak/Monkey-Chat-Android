package com.criptext.monkeychatandroid;

import android.content.Context;
import android.os.Environment;

import com.crashlytics.android.Crashlytics;

import java.io.File;

import io.fabric.sdk.android.Fabric;

/**
 * Application class. This class is only used to store a few global constants. It also holds the
 * configuration for the default realm.
 * Created by Daniel Tigse on 4/19/16.
 */

public class MonkeyChat extends com.activeandroid.app.Application{


    private static MonkeyChat singleton;

    /**
     * Constant used to store in Shared Preferences the current user's monkey ID. You need this
     * to start the MonkeyKitSocketService.
     */
    public static String MONKEY_ID = "MonkeyChat.MonkeyId";
    /**
     * Constant used to store in Shared Preferences a boolean that indicates whether the current
     * user has registered with GCM and has successfully subscribed this device to the MonkeyKit Server
     * in order to receive push notifications.
     */
    public static String IS_REGISTERED = "MonkeyChat.IsRegistered";
    /**
     * Constant used to store in Shared Preferences the name of the current user. this is also needed
     * to start the MonkeyKitSocketService.
     */
    public static String FULLNAME = "MonkeyChat.FullName";
    public static String SOCKET_DOMAIN = "MonkeyChat.SocketDomain";
    public static String SOCKET_PORT = "MonkeyChat.SocketPort";

    public static String PHOTOS_DIR = "photos";
    public static String VOICENOTES_DIR = "voice notes";


    public static File getDownloadDir(Context ctx) {
        File downloadDir = new File(Environment.getExternalStorageDirectory(),
                ctx.getResources().getString(R.string.app_name));
        downloadDir.mkdirs();
        File subdir = new File(downloadDir, MonkeyChat.PHOTOS_DIR);
        subdir.mkdir();
        subdir = new File(downloadDir, MonkeyChat.VOICENOTES_DIR);
        subdir.mkdir();
        return downloadDir;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        singleton = this;
    }

    public static MonkeyChat getInstance(){
        return singleton;
    }

}
