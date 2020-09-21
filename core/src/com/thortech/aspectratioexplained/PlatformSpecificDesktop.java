package com.thortech.aspectratioexplained;

/**
 * Created by ToHj on 16-02-2016.
 */
public class PlatformSpecificDesktop implements PlatformSpecific {

    public static boolean isDebug;
    public PlatformSpecificDesktop()
    {
        //isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
        isDebug = false;
    }

    @Override
    public void login() {

    }

    @Override
    public void showBannerAd() {

    }

    @Override
    public void hideBannerAd() {

    }

    @Override
    public void unlockAchievement(int higsocreId) {

    }

    @Override
    public void postHighscore(int score) {

    }
    @Override
    public boolean isDebug(){
        return isDebug;
    }
}
