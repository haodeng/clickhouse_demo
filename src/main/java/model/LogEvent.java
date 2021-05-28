package model;

import java.util.UUID;

public class LogEvent {
    public final UUID eventId;
    public final String event;
    public final Long time;
    public final String message;

    private LogEvent(UUID eventId, String event, Long time, String message) {
        this.eventId = eventId;
        this.event = event;
        this.time = time;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[eventId=" + eventId + ", event=" + event + ", time=" + time + ", message=" + message + "]";
    }
}
