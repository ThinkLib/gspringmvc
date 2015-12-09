package csb.model

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
/**
 * Created by dneufeld on 12/4/15.
 */
@Component
class DataProviders {

    private static final Logger logger =
            LoggerFactory.getLogger DataProviders.class

    def hmProviders = new HashMap()

    public DataProviders( List dpsConfigList ) {
        dpsConfigList.each { p ->
            logger.debug(p.toString())
            this.addProvider( "${p.name}", p)
        }
    }
    void addProvider( String name, def dpConfigMap ) {
        def dp = new DataProvider()
        dp.uid = "${dpConfigMap.uid}"
        logger.debug("dp.uid=${dp.uid}")
        dp.name = "${dpConfigMap.name}"
        dp.providerEmail = "${dpConfigMap.providerEmail}"
        dp.processorEmail = "${dpConfigMap.processorEmail}"
        dp.ownerEmail = "${dpConfigMap.ownerEmail}"
        logger.debug("addProvider: ${dpConfigMap.toString()}")
        this.hmProviders.put(name, dp)
    }

    DataProvider getProvider( String name ) {
        return this.hmProviders.get( name )
    }
}