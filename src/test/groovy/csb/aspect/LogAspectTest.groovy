package csb.aspect

import csb.config.AppConfig
import csb.service.ISubmitService

import org.springframework.context.annotation.ComponentScan

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@ComponentScan( basePackages=[ "csb.service","csb.config","csb.aspect" ] )
public class LogAspectTest {

    @Autowired
    private ISubmitService ss

    @Test
    public void transformSad() {

        ss.getName()

    }

}