package com.svintsov.vk.global;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.HashMap;

public class StateHolder {

    private final String stateHolderTag;
    private final FragmentManager fragmentManager;
    private StateHolderFragment stateHolderFragment;

    public StateHolder(FragmentManager fragmentManager, String stateHolderTag) {
        this.fragmentManager = fragmentManager;
        this.stateHolderTag = stateHolderTag;
    }

    /**
     * Create the state maintainer fragment
     *
     * @return true: the frag was created for the first time
     * false: recovering the object
     */
    public boolean firstTimeIn() {
        // Recovering the reference
        stateHolderFragment = (StateHolderFragment) fragmentManager.findFragmentByTag(stateHolderTag);
        // Creating a new RetainedFragment
        if (stateHolderFragment == null) {
            stateHolderFragment = new StateHolderFragment();
            fragmentManager
                    .beginTransaction()
                    .add(stateHolderFragment, stateHolderTag)
                    .commit();
            return true;
        }
        return false;
    }

    /**
     * Insert Object to be preserved during configuration change
     *
     * @param key Object's TAG reference
     * @param obj Object to maintain
     */
    public void put(String key, Object obj) {
        stateHolderFragment.put(key, obj);
    }

    /**
     * Insert Object to be preserved during configuration change
     * Uses the Object's class name as a TAG reference
     * Should only be used one time by type class
     *
     * @param obj Object to maintain
     */
    public void put(Object obj) {
        put(obj.getClass().getName(), obj);
    }

    /**
     * Recovers saved object
     *
     * @param key TAG reference
     * @param <T> Class type
     * @return Objects
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return stateHolderFragment.get(key);
    }

    /**
     * Verify the object existence
     *
     * @param key Obj TAG
     */
    public boolean hasKey(String key) {
        return stateHolderFragment.get(key) != null;
    }

    /**
     * Save and manages objects that show be preserved
     * during configuration changes.
     */
    public static class StateHolderFragment extends Fragment {

        private HashMap<String, Object> data = new HashMap<>();

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
        }

        /**
         * Insert objects
         *
         * @param key reference TAG
         * @param obj Object to save
         */
        public void put(String key, Object obj) {
            data.put(key, obj);
        }

        /**
         * Insert obj using class name as TAG
         *
         * @param object obj to save
         */
        public void put(Object object) {
            put(object.getClass().getName(), object);
        }

        /**
         * Recover obj
         *
         * @param key reference TAG
         * @param <T> Class
         * @return Obj saved
         */
        @SuppressWarnings("unchecked")
        public <T> T get(String key) {
            return (T) data.get(key);
        }
    }
}