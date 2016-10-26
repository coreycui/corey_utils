package org.corey.net;

import java.net.SocketException;
import java.nio.channels.SocketChannel;

public class FastCloseSockUtil {
	public static void fastCloseSock(SocketChannel sc) {
        if (sc != null) {
            try {
                // Hard close immediately, discarding buffers
                sc.socket().setSoLinger(true, 0);
            } catch (SocketException e) {
                //LOG.warn("Unable to set socket linger to 0, socket close"
                //         + " may stall in CLOSE_WAIT", e);
            }
        }
    }
}
