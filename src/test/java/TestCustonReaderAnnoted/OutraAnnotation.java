package TestCustonReaderAnnoted;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
@PropertyAnnotation(ExecuteProcessors.class)
public @interface OutraAnnotation {

}
