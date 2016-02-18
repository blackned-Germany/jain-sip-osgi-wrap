package gov.nist.core;

import org.slf4j.Logger;

import java.util.Properties;

public class CommonLoggerSlf4j implements StackLogger {
    private Logger logger;

    public CommonLoggerSlf4j(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void logStackTrace() {}

    @Override
    public void logStackTrace(int traceLevel) {}

    @Override
    public int getLineCount() {
        return 0;
    }

    @Override
    public void logException(Throwable ex) {
        logger.error("Error", ex);
    }

    @Override
    public void logDebug(String message) {
        logger.debug(message);
    }

    @Override
    public void logTrace(String message) {
        logger.trace(message);
    }

    @Override
    public void logFatalError(String message) {
        logger.error(message);
    }

    @Override
    public void logError(String message) {
        logger.error(message);
    }

    @Override
    public boolean isLoggingEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isLoggingEnabled(int logLevel) {
        switch(logLevel) {
            case TRACE_INFO: return logger.isInfoEnabled();
            case TRACE_DEBUG: return logger.isDebugEnabled();
            case TRACE_ERROR: return logger.isErrorEnabled();
            case TRACE_WARN: return logger.isWarnEnabled();
            case TRACE_TRACE: return logger.isTraceEnabled();
            case TRACE_FATAL: return logger.isErrorEnabled();
        }
        return false;
    }


    @Override
    public void logError(String message, Exception ex) {
        logger.error(message, ex);
    }

    @Override
    public void logWarning(String string) {
        logger.warn(string);
    }

    @Override
    public void logInfo(String string) {
        logger.info(string);
    }

    @Override
    public void disableLogging() {}

    @Override
    public void enableLogging() {}

    @Override
    public void setBuildTimeStamp(String buildTimeStamp) {}

    @Override
    public void setStackProperties(Properties stackProperties) {}

    @Override
    public String getLoggerName() {
        return logger.getName();
    }
}
