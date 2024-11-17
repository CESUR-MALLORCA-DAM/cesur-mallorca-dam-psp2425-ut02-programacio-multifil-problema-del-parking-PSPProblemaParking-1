public enum Emoji {
    PARKINGLOT("\uD83C\uDD7F"),
    RUNNINGCAR("\uD83D\uDE97"),
    GREETING("\uD83D\uDC4B"),
    TRAFFICLIGHT("\uD83D\uDEA6"),
    REDSPOTLIGHT("\uD83D\uDD34"),
    GREENSPOTLIGHT("\uD83D\uDFE2");

    private final String code;

    Emoji(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
