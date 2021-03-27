package jp.co.next_evolution.sample.common;

public enum ActionResult {
    OK(0),
    Warn(1),
    Error(2),
    Fatal(Integer.MAX_VALUE);

    private final int code;

    ActionResult(int code) {
        this.code = code;
    }

    public static ActionResult fromCode(int code) {
        for (ActionResult myEnum : ActionResult.values()) {
            if (myEnum.code == code) {
                return myEnum;
            }
        }
        return null;
    }

    public static boolean contains(int code) {
        for (ActionResult myEnum : ActionResult.values()) {
            if (myEnum.code == code) {
                return true;
            }
        }
        return false;
    }

    public int getCode() {
        return this.code;
    }

    public int getValue() {
        return this.code;
    }
}
