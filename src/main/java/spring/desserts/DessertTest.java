package spring.desserts;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.desserts.annotations.Cold;
import spring.desserts.annotations.Frutty;
import spring.desserts.classes.Dessert;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DessertConfiguration.class)
public class DessertTest {

    @Autowired
    @Cold
    @Frutty
    private Dessert dessert_1;

    @Autowired
    @Qualifier("soft")
    private Dessert dessert_2;

    @Autowired
    @Qualifier("cookies")
    private Dessert dessert_3;

    @Test
    public void notNullTest() {
        assertNotNull(dessert_1);
        assertNotNull(dessert_2);
        assertNotNull(dessert_3);
    }

}
