import com.virtusai.clickhouseclient.ClickHouseClient;
import model.LogEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class ClickHouseAdaptor {
    private ClickHouseClient clickHouseClient;

    public void initConnection() {
        if (clickHouseClient == null) {
            clickHouseClient = new ClickHouseClient("http://localhost:8123", "default", "");
        }
    }

    public void closeConnection() {
        if (clickHouseClient != null) {
            clickHouseClient.close();
        }
    }

    public void insertLogEvents() {
        List<Object[]> rows = new ArrayList<>();

        IntStream.range(1, 10)
                .forEach(i -> rows.add(generateRow()));

        clickHouseClient.post("INSERT INTO test.logevent", rows);
    }

    public List<LogEvent> getLogEvent() throws ExecutionException, InterruptedException {
        return clickHouseClient
                .get("SELECT * from test.logevent", LogEvent.class)
                .get()
                .data;
    }

    private static Object[] generateRow() {
        UUID eventId = UUID.randomUUID();
        String event = "ping";
        long time = System.currentTimeMillis();
        String message = "{\"ping: 30ms\"}";

        return new Object[] { eventId, event, time, message };
    }


}
