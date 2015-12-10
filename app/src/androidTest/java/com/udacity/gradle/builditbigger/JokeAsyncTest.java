package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * Created by Menno on 10-12-2015.
 */

public class JokeAsyncTest extends AndroidTestCase implements IJokeResponse {

    GetJokeAsyncTask task;
    CountDownLatch signal;
    private String m_joke = "";

    public void testGetJoke() {
        assertTrue(m_joke.equals(""));

        signal = new CountDownLatch(1);
        task = new GetJokeAsyncTask();
        task.delegate = this;

        task.execute();

        try {
            signal.await(30, TimeUnit.SECONDS);
            Assert.assertFalse(m_joke.equals(""));
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }
    }

    public void OnReceiveJoke(String joke)
    {
        m_joke = joke;
        signal.countDown();
    }
}
