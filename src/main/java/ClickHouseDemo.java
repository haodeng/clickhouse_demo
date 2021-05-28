public class ClickHouseDemo {

    public static void main(String[] args) throws Exception {
        ClickHouseAdaptor adaptor = new ClickHouseAdaptor();
        adaptor.initConnection();

//        adaptor.insertLogEvents();
        adaptor.getLogEvent()
                .forEach(System.out::println);

        adaptor.closeConnection();
    }
}
