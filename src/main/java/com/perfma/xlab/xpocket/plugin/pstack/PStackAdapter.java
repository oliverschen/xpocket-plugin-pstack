package com.perfma.xlab.xpocket.plugin.pstack;

import com.perfma.xlab.xpocket.spi.process.XPocketProcess;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * process command
 * @author jihe
 */
public class PStackAdapter {


    public static void invoke(XPocketProcess process) {
        String cmd = parseCommandStr(process.getCmd(),process.getArgs());
        String result = execCommand(cmd);
        process.output(result);
        process.end();
    }

    /**
     * execute command
     */
    public static String execCommand(String cmd) {
        CommandLine commandLine = CommandLine.parse(cmd);
        DefaultExecutor executor = new DefaultExecutor();

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ByteArrayOutputStream err = new ByteArrayOutputStream()) {

            PumpStreamHandler handler = new PumpStreamHandler(out, err);
            executor.setStreamHandler(handler);
            executor.execute(commandLine);
            return out.toString(Charset.defaultCharset().toString()) +
                    err.toString(Charset.defaultCharset().toString());
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * join cmd and args
     */
    private static String parseCommandStr(String cmd, String[] args) {
        return cmd + " " + String.join(" ", args);
    }
}
