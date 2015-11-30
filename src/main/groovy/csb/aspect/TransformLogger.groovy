package csb.aspect

/**
 * Created by dneufeld on 11/29/15.
 */

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Aspect
@Component
public class TransformLogger {

    private static final Logger logger =
            LoggerFactory.getLogger( TransformLogger.class )

    @Before( "execution(** csb.service.SubmitService.getName())" )
    public void startTransformLogging() {
        logger.debug( "Begin transform...");
    }

}
