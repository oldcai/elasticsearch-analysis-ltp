package demo.lonly.stp.core;

import org.elasticsearch.SpecialPermission;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by Lonly on 2016/7/22.
 */
public class LocalSegmenterFactory {

    public static ESLogger logger = Loggers.getLogger("LocalSegmenterFactory");

    public static LocalSegmenter build(String path){
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new SpecialPermission());
        }
        final String model_path = path;
        return AccessController.doPrivileged(new PrivilegedAction<LocalSegmenter>() {
            @Override
            public LocalSegmenter run() {
                //return new LocalSegmenter(path);
                return null;
            }
        });
    }
}