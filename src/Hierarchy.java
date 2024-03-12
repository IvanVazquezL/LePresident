public enum Hierarchy {
    PRESIDENT("President"),
    VICEPRESIDENT("Vice President"),
    CITIZEN("Citizen"),
    VICEASSHOLE("Vice Asshole"),
    ASSHOLE("Asshole");

    private final String hierarchy;

    Hierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getHierarchy() {
        return hierarchy;
    }
}
