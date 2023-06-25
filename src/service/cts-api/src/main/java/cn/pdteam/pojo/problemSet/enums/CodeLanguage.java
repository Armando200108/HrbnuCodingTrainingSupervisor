package cn.pdteam.pojo.problemSet.enums;

/**
 * 代码语言
 *
 * @author Armando
 */
public enum CodeLanguage {
    /**
     * java
     */
    JAVA("java", "Java"),
    /**
     * c++
     */
    CPP("cpp", "C++");
    private String language;
    private String languageName;

    public String getLanguage() {
        return language;
    }

    public CodeLanguage setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getLanguageName() {
        return languageName;
    }

    public CodeLanguage setLanguageName(String languageName) {
        this.languageName = languageName;
        return this;
    }

    CodeLanguage(String language, String languageName) {
        this.language = language;
        this.languageName = languageName;
    }
}
