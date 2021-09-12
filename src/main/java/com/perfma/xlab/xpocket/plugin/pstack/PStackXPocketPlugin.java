package com.perfma.xlab.xpocket.plugin.pstack;

import com.perfma.xlab.xpocket.spi.AbstractXPocketPlugin;
import com.perfma.xlab.xpocket.spi.process.XPocketProcess;

/**
 * @author jihe
 */
public class PStackXPocketPlugin extends AbstractXPocketPlugin {

    private static final String LOGO = "               _____             ______  \n" +
            "_________________  /______ _________  /__\n" +
            "___  __ \\_  ___/  __/  __ `/  ___/_  //_/\n" +
            "__  /_/ /(__  )/ /_ / /_/ // /__ _  ,<   \n" +
            "_  .___//____/ \\__/ \\__,_/ \\___/ /_/|_|  \n" +
            "/_/                                      ";


    @Override
    public void printLogo(XPocketProcess process) {
        process.output(LOGO);
    }
}
