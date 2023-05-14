package SystemUtil;

public enum Language {
    Default("_Default_"),
    Chinese("Chinese"),
    English("English"),
    Russian("Russian");

    public final String name;

    Language(String Name) {
        this.name = Name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean EqualsTo(Language language) {
        return this.ordinal() == language.ordinal();
    }

    public static Language GetLanguage(String name) {
        for (Language language : Language.values()) {
            if (language.name.equals(name))
                return language;
        }
        System.err.println("Cannot find language:" + name);
        return null;
    }
}
