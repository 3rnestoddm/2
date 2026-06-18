package com.ernesto.cambridgeone;

final class FrameStore {
    static final class Frame {
        final long version;
        final byte[] jpeg;
        final int width;
        final int height;
        final long createdAtMs;

        Frame(long version, byte[] jpeg, int width, int height, long createdAtMs) {
            this.version = version;
            this.jpeg = jpeg;
            this.width = width;
            this.height = height;
            this.createdAtMs = createdAtMs;
        }
    }

    private final Object lock = new Object();
    private Frame latest;
    private long version;

    void update(byte[] jpeg, int width, int height, long createdAtMs) {
        synchronized (lock) {
            version++;
            latest = new Frame(version, jpeg, width, height, createdAtMs);
            lock.notifyAll();
        }
    }

    Frame latest() {
        synchronized (lock) { return latest; }
    }

    Frame awaitNext(long afterVersion, long timeoutMs) throws InterruptedException {
        synchronized (lock) {
            if (version <= afterVersion) lock.wait(timeoutMs);
            return latest != null && latest.version > afterVersion ? latest : null;
        }
    }
}
