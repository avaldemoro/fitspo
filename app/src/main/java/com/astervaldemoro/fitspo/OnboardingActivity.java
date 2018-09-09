package com.astervaldemoro.fitspo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.astervaldemoro.fitspo.fragments.OnboardingInfoFragment;
import com.astervaldemoro.fitspo.utils.Constant;
import java.io.IOException;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_onboarding);

        Bundle bundle = new Bundle();
        OnboardingInfoFragment onboardingInfoFragment = new OnboardingInfoFragment ();
        onboardingInfoFragment.setArguments (bundle);

        getSupportFragmentManager ().beginTransaction ()
                .replace (R.id.onboarding_frame_container, onboardingInfoFragment)
                .commit ();

    }

    /*** CHECKS IF ONLINE
     * https://stackoverflow.com/questions/1560788/how-to-check-internet-access-on-android-inetaddress-never-times-out ***/
    public static boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec(Constant.INTERNET_CHECK_COMMAND);
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        }
        catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }
}
