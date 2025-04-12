CREATE TABLE language (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE word (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE word_translation (
    word_id BIGINT NOT NULL,
    language_id BIGINT NOT NULL,
    translated_word VARCHAR(255),
    translated_example VARCHAR(255),
    translated_description VARCHAR(255),
    image_url VARCHAR(255),
    PRIMARY KEY (word_id, language_id),
    FOREIGN KEY (word_id) REFERENCES word(id),
    FOREIGN KEY (language_id) REFERENCES language(id)
);
