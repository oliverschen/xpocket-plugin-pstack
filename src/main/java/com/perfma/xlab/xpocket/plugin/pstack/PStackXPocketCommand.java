package com.perfma.xlab.xpocket.plugin.pstack;

import com.perfma.xlab.xpocket.spi.command.AbstractXPocketCommand;
import com.perfma.xlab.xpocket.spi.command.CommandInfo;
import com.perfma.xlab.xpocket.spi.process.XPocketProcess;

/**
 * @author jihe
 */
@CommandInfo(name = "pstack", usage = "Usage: pstack <process-id>")
public class PStackXPocketCommand extends AbstractXPocketCommand {


    @Override
    public void invoke(XPocketProcess process) throws Throwable {
        PStackAdapter.invoke(process);
        process.end();
    }
}
