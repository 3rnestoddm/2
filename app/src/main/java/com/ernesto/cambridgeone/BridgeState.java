package com.ernesto.cambridgeone;

import java.util.concurrent.atomic.AtomicInteger;

final class BridgeState {
    volatile String token = "000000";
    volatile String wifiIp;
    volatile String cameraName = "FRONT";
    volatile float measuredFps;
    volatile int jpegQuality = 75;
    volatile int targetFps = 24;
    volatile int maxEdge = 1280;
    volatile boolean bridgeRunning;
    final AtomicInteger viewers = new AtomicInteger();
}
