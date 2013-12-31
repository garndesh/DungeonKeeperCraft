package garndesh.dkc.helper;

import garndesh.dkc.lib.Reference;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

/*
Mostly copied from Pahimar EE3
*/
public class LogHelper {

    private static Logger bmLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init()
    {
        bmLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, Object object)
    {
        if (object != null)
        {
            bmLogger.log(logLevel, object.toString());
        }
        else
        {
            bmLogger.log(logLevel, "null");
        }
    }
    
    public static void severe(Object object)
    {
        log(Level.SEVERE, object);
    }

    public static void warning(Object object)
    {
        log(Level.WARNING, object);
    }

    public static void info(Object object)
    {
        log(Level.INFO, object);
    }

    public static void config(Object object)
    {
        log(Level.CONFIG, object);
    }

    public static void fine(Object object)
    {
        log(Level.FINE, object);
    }

    public static void finer(Object object)
    {
        log(Level.FINER, object);
    }

    public static void finest(Object object)
    {
        log(Level.FINEST, object);
    }

}
