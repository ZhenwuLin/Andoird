package com.example.fragmentswitcherdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FragmentSwitcher {


    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private FragmentManager fragmentManager;
    private int containerResId;
    private int currentIndex = -1;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public FragmentSwitcher(FragmentManager fragmentManager, int containerResId) {
        this.fragmentManager = fragmentManager;
        this.containerResId = containerResId;
    }

    /**
     * add fragment
     */
    public void addFragment(Fragment f, String tag) {
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = f;
        }
        fragments.add(fragment);
        tags.add(tag);
    }

    /**
     * get index fragment
     *
     * @return index fragment
     */
    public Fragment getFragment(int index) {
        return index < fragments.size() ? fragments.get(index) : null;
    }

    /**
     * switch index fragment
     */
    public void switchToFragment(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag(tags.get(index));
        if (fragment == null) {
            fragment = fragments.get(index);
            fragmentTransaction.add(containerResId, fragment, tags.get(index));
            fragmentTransaction.hide(fragment);
        }
        if (index != currentIndex) {
            for (int i = 0; i < fragments.size(); i++) {
                if (i != index) {
                    Fragment f = fragmentManager.findFragmentByTag(tags.get(i));
                    if (f != null) {
                        fragmentTransaction.hide(fragments.get(i));
                    }
                }
            }
        }

        fragmentTransaction.show(fragment);

        currentIndex = index;
        fragmentTransaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    public void replaceOrAddFragment(Fragment fragment, int index, String tag) {
        if (index > getFragmentSize() - 1) {
            addFragment(fragment, tag);
        } else {
            Fragment oldFragment = getFragment(index);
            if (oldFragment != null && oldFragment != fragment) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(oldFragment);
                Fragment f = fragmentManager.findFragmentByTag(tag);
                if (f != null) {
                    fragments.set(index, f);
                } else {
                    fragments.set(index, fragment);
                }
                fragmentTransaction.commit();
                if (index == currentIndex) {
                    switchToFragment(index);
                }
            }
        }
    }

    public int getFragmentSize() {
        return fragments.size();
    }

}
