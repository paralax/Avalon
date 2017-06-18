package avalon.extend;

import avalon.group.MainGroupMessageHandler;
import org.slf4j.LoggerFactory;

import static avalon.tool.pool.ConstantPool.Basic.currentServlet;

/**
 * Created by Eldath on 2017/1/31 0031.
 *
 * @author Eldath
 */
public class ShowMsgTask implements Task {
    private String message;

    ShowMsgTask(String input) {
        this.message = input;
    }

    @Override
    public void run() {
        LoggerFactory.getLogger(ShowMsgTask.class).info("echo message \"" +
                message.replace("\n", "") + "\" to every group.");
        long[] followGroups = MainGroupMessageHandler.getInstance().getFollowGroup();
        for (long thisNeedShow : followGroups)
            currentServlet.responseGroup(thisNeedShow, message);
    }

    @Override
    public String toString() {
        return "ShowMsgTask{" + message + "}";
    }
}
