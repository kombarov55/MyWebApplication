package com.vk.kombarov_nikolay.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nikolaykombarov on 16.02.17.
 */
public class HibernateTest {

    private SessionFactory sf;

    @Before
    public void init() {
        sf = new Configuration().configure().buildSessionFactory();
    }


    @Test
    public void test() throws Exception {
        Session session = sf.openSession();

    }

}
