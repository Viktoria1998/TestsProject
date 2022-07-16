package ru.mos.emias.onco.helpers;

import lombok.Getter;
import net.lightbody.bmp.BrowserMobProxyServer;

import java.net.Inet4Address;

public class ProxyHelper {
    BrowserMobProxyServer proxy;
    String authorizationKey = "X_REMOTE_USER";
    String userName;
    @Getter
    String ipAddress;

    public ProxyHelper() throws Exception {
        this.ipAddress = Inet4Address.getLocalHost().getHostAddress();
    }

    public BrowserMobProxyServer setUpProxy(String userName){
        this.userName = userName;
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
//        proxy.addHeader(authorizationKey, this.userName);
        proxy.addRequestFilter((request, content, messageInfo)->{
            if (request.headers().contains(authorizationKey)) {
                request.headers().remove(authorizationKey);
            }
            request.headers().add(authorizationKey, userName);
            return null;
        });
//        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//        proxy.newHar("har");
        return proxy;
    }
}
