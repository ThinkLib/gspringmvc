package csb.config

import csb.aspect.TransformLogger
import csb.dsmodelinput.*
import csb.service.GeoJsonService
import csb.service.ITransformService
import csb.service.SubmitService

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy
class AppConfig {

    private static final Logger logger =
            LoggerFactory.getLogger AppConfig.class

    @Bean
    public Staging staging() {

        logger.debug "Staging bean construction..."

        // get active profile
        String activeProfile = System.getProperty "spring.profiles.active"
        def config = new ConfigSlurper("${activeProfile}").parse(
                new File("config/appConfig.groovy").toURI().toURL())

        logger.debug "activeProfile=${activeProfile}"

        Staging staging = new Staging( config.staging.dir.map )
        return staging

    }

    @Bean
    public ITransformService ss() {

        ITransformService ss = new SubmitService( staging() )
        return ss

    }

    @Bean
    public ITransformService gs() {

        ITransformService gs = new GeoJsonService( staging() )
        return gs

    }

    @Bean
    public TransformLogger tLogger() {

        return new TransformLogger()

    }
}
