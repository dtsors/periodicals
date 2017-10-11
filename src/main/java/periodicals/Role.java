package periodicals;

public enum Role {
    ADMIN {
        @Override
        public String toString() {
            return "admin";
        }
    },
    SUBSCRIBER {
        @Override
        public String toString() {
            return "subscriber";
        }
    }
}
