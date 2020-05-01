package cn.ykstudy.xxx.websocket;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author: yangk
 * @create: 2020/4/1 0:02
 * @program:
 * @description:
 **/
@Slf4j
public class WebsocketClient {
    public static WebSocketClient client;

    public static void main(String[] args) {
        try {
            client = new WebSocketClient(new URI("ws://121.40.165.18:8800"), new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    log.info("握手成功");
                }

                @Override
                public void onMessage(String msg) {
                    log.info("收到消息==========" + msg);
                    if (msg.equals("over")) {
                        client.close();
                    }
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    log.info("链接已关闭");
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    log.info("发生错误已关闭");
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        client.connect();
        //log.info(client.getDraft());
        while (!client.getReadyState().equals(ReadyState.OPEN)) {
            log.info("正在连接...");
        }
        //连接成功,发送信息
        client.send("哈喽,连接一下啊");
    }
}
