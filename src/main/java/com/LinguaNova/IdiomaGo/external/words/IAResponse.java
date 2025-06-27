package com.LinguaNova.IdiomaGo.external.words;

public class IAResponse {
    private String word;
    private String example;
    private String description;

    public IAResponse(String word, String example, String description) {
        this.word = word;
        this.example = example;
        this.description = description;
    }

    public String getWord() { return word; }
    public String getExample() { return example; }
    public String getDescription() { return description; }

    public void setWord(String word) { this.word = word; }
    public void setExample(String example) { this.example = example; }
    public void setDescription(String description) { this.description = description; }
}
